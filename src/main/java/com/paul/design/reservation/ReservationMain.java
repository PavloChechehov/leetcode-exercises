package com.paul.design.reservation;

/**
 * Classic reservation table problem
 */

public class ReservationMain {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        restaurant.addTable(new Table(1, 4));

        System.out.println(restaurant.bookTable(1, 10, 12)); // true
        System.out.println(restaurant.bookTable(1, 12, 14)); // true
        System.out.println(restaurant.bookTable(1, 11, 13)); // false (overlap)
        System.out.println(restaurant.bookTable(2, 11, 13)); // Table not found exception
    }


}
