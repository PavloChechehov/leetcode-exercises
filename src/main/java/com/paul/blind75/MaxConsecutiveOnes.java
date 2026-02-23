package com.paul.blind75;


/**
 * <a href="https://leetcode.com/problems/max-consecutive-ones-iii/description/">1004. Max Consecutive Ones III</a>
 *
 */

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int res = longestOnes(nums, k);
        System.out.println(res == 6);
    }

    public static int longestOnes(int[] nums, int k) {
        //1,1,1,0,0,0,1,1,1,1,0,  k = 2
        //        r
        //  l
        int l = 0;
        int r = 0;
        int count = k;

        int n = nums.length;
        int max = 0;
        while (l <= r && r < n) {
            //0,0,1,1,1,0,0

            if(count == 0 && nums[r] == 0 && nums[l] == 0) {
                l++;
                r++;
                continue;
            }

            if (nums[r] == 1) {
                r++;
            } else if (nums[r] == 0 && count > 0) {
                r++;
                count--;

            } else {
                if(nums[l] == 0 && count < k) {
                    count++;
                }
                l++;
            }

            max = Math.max(r - l, max);


        }

        return max;
    }
}
