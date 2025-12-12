package com.paul.atlassian;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Logger {

    // HashMap to store message and its next allowed timestamp
    private static Map<String, Long> messageTimestampMap =  new HashMap<>();

//    /**
//     * Initialize your data structure here.
//     */
//    public Logger() {
//        messageTimestampMap =
//    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns
     * false. If this method returns false, the message will not be printed. The timestamp is in
     * seconds granularity.
     *
     * @param timestamp The current timestamp in seconds
     * @param message The message to be printed
     * @return true if the message should be printed, false otherwise
     */
    public static boolean shouldPrintMessage(long timestamp, String message) {
        // Get the next allowed timestamp for this message (0 if message hasn't been seen before)
        long nextAllowedTimestamp = messageTimestampMap.getOrDefault(message, 0L);

        // If current timestamp is before the next allowed timestamp, reject the message
        if (nextAllowedTimestamp > timestamp) {
            return false;
        }

        // Update the next allowed timestamp for this message (current + 10 seconds)
        messageTimestampMap.put(message, timestamp + 1000);

        // Allow the message to be printed
        return true;
    }


    private static final Map<Integer, String> map = Map.of(1, "foo", 2, "bar", 3, "zoo");
    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            String message = map.get(random.nextInt(1, 3));
            if (shouldPrintMessage(System.currentTimeMillis(), message)) {
                System.out.println(message);
            } else {
                System.out.println("NOT ALLOW");
            }
            Thread.sleep(100);

        }
    }
}
