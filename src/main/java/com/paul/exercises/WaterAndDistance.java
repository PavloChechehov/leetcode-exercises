package com.paul.exercises;

public class WaterAndDistance {

    public static void main(String[] args) {
//        int[] landStartTime = {2, 8};
        int[] landStartTime = {99};
//        int[] landDuration = {4, 1};
        int[] landDuration = {59};
//        int[] waterStartTime = {6};
        int[] waterStartTime = {99,54};
//        int[] waterDuration = {3};
        int[] waterDuration = {85,20};

        int res = earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        System.out.println(res);

    }


    public static int earliestFinishTime(int[] landStartTime,
                                  int[] landDuration,
                                  int[] waterStartTime,
                                  int[] waterDuration) {


        int n = landStartTime.length;
        int m = waterStartTime.length;

        int min1 = getMin(waterStartTime, waterDuration, landStartTime, landDuration);
        int min2 = getMin(landStartTime, landDuration, waterStartTime, waterDuration);

        return Math.min(min1, min2);

    }

    private static int getMin(int[] startTime1,
                              int[] duration1,
                              int[] startTime2,
                              int[] duration2) {

        int min = Integer.MAX_VALUE;

        int n = startTime1.length;
        int m = startTime2.length;

        for(int i = 0; i < m; i++) {

            int start = startTime2[i] + duration2[i];

            for (int j = 0; j < n; j++) {

                int finish =  Math.max(start, startTime1[j]) + duration1[j];

                min = Math.min(finish, min);
            }
        }
        return min;
    }
}
