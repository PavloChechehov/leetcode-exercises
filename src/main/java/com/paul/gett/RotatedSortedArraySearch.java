package com.paul.gett;

public class RotatedSortedArraySearch {
    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {1, 3};


        int res = searchRotated(nums, 3);

        System.out.println(res);
    }

    /*

    Input examples
    nums = [4,5,6,7,0,1,2], target = 0 → output: 4
    nums = [4,5,6,7,0,1,2], target = 3 → output: -1
    nums = [1], target = 0 → output: -1
    nums = [1,3], target = 3 → output: 1

    Requirements:
    - Time complexity: O(log n)
    - No sorting
    - No extra array
    - Strict binary search approach

    * */

    //find the pivot, we can do it by take the random number and find out if it less of more that the target number
    //do the same before we find the target element
    private static int searchRotated(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l <= r) {

           int mid = l + (r - l)/2;


            if (nums[mid] == target) {
                return mid;
            }

//            4,5,6,7,0,1,2
           if (nums[l] <= nums[mid]) {
               //sorted part of the array?
                //4 <= 0 and 0 <= 6
               if (nums[l] <= target && target <= nums[mid]) {
                   r = mid - 1;
               } else {
                   l = mid + 1;
               }

           } else {

               // 3 <= 2
               if (nums[mid] <= target && target <= nums[r]) {
                   l = mid + 1;
               } else {
                   r = mid - 1;
               }

           }



        }


        return -1;
    }
}



/*
could you help me, because i don't understand:
nums = [4,5,6,7,0,1,2], target = 0 → output: 4
and when we're using the pivot - is a random number between [0, lenght)
1 iteration - lets be the 2, nums[2] is a 6, left is 5, right is 7.
The possible target could be in the left side of the pivot and the right side of the pivot.
We don't know exactly where we must to move?


*
* */
