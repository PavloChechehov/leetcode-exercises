package com.paul.design.reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

class Restaurant {

    private final List<Table> tables = new ArrayList<>();
    private final Map<Table, List<RangeReservation>> reservations = new HashMap<>();
    private final ReentrantLock lock = new ReentrantLock();

    /* ----------------- Setup ----------------- */

    public void addTable(Table table) {
        lock.lock();
        try {
            tables.add(table);
            reservations.putIfAbsent(table, new ArrayList<>());
        } finally {
            lock.unlock();
        }
    }

    /* ----------------- Booking API ----------------- */

    /**
     * Attempts to book a table for a given time range.
     *
     * @return true if booking succeeded, false if table already reserved
     */
    public boolean bookTable(int tableId, int start, int finish) {
        validateRange(start, finish);

        lock.lock();
        try {
            Table table = findTableById(tableId);
            List<RangeReservation> tableReservations =
                    reservations.computeIfAbsent(table, k -> new ArrayList<>());

            if (isTableReserved(start, finish, tableReservations)) {
                return false;
            }

            tableReservations.add(new RangeReservation(start, finish));
            return true;
        } finally {
            lock.unlock();
        }
    }

    /* ----------------- Internal helpers ----------------- */

    private Table findTableById(int tableId) {
        return tables.stream()
                .filter(t -> t.tableId() == tableId)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Table not found: " + tableId));
    }

    private static boolean isTableReserved(
            int start,
            int finish,
            List<RangeReservation> reservations
    ) {
        for (RangeReservation existing : reservations) {
            if (rangesOverlap(start, finish, existing.start(), existing.finish())) {
                return true;
            }
        }
        return false;
    }

    private static boolean rangesOverlap(
            int newStart,
            int newFinish,
            int existingStart,
            int existingFinish
    ) {
        return newStart < existingFinish && newFinish > existingStart;
    }

    private static void validateRange(int start, int finish) {
        if (start >= finish) {
            throw new IllegalArgumentException("Invalid time range");
        }
    }
}


record Table(int tableId, int numberOfSeats) {
}

record RangeReservation(int start, int finish) {
}