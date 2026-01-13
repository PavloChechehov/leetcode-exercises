package com.paul.google.week1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;


/**
 * <a href="https://leetcode.com/problems/maximum-units-on-a-truck/description/">1710. Maximum Units on a Truck</a>
 */
public class MaximumUnits {


    public static void main(String[] args) {
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;

        int res = maximumUnits(boxTypes, truckSize);
        System.out.println(res);

    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;

        Arrays.sort(boxTypes, Comparator.comparing(ints -> -ints[1]));


        for (int[] type : boxTypes) {
            int numberOfBoxes = type[1];

            if (truckSize == 0) {
                break;
            }

            int min = Math.min(truckSize, type[0]);

            truckSize -= min;
            type[0] = type[0] - min;
            res += numberOfBoxes * min;
        }


        return res;
    }

}
