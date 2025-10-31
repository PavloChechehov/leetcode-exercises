package com.paul.dp;

/**
* Jump game <a href="https://leetcode.com/problems/jump-game/">link</a>
* */

public class JumpGame {
        public boolean canJump(int[] nums) {
            //[2,3,1,1,4]
            // 2 -> 1 -> 1 -> 4 is this end -> yes return true

            //3,2,1,0,4
            //3 -> 0
            //

            int reachable = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > reachable) return false; // can't reach this index
                reachable = Math.max(reachable, i + nums[i]);
            }
            return true;
        }

}
