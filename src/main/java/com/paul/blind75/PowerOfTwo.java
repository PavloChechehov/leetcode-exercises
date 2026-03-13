package com.paul.blind75;

/**
 * <a href="https://leetcode.com/problems/power-of-two/description/">231. Power of Two</a>
 * 231. Power of Two
 */
public class PowerOfTwo {


        public boolean isPowerOfTwo(int n) {
            if (n < 0) return false;
            if (n == 0) return false;

            int pow = 0;
            //16 - 8 - 4 - 2 - 1

            int curr = n;

            while(curr != 1) {
                curr /= 2;
                pow++;
            }


            for(int i = 0; i < pow; i++){
                curr *= 2;
            }

            return n == curr;
        }
}
