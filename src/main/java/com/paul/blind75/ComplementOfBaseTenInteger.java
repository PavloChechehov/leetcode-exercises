package com.paul.blind75;


/**
 * <a href="https://leetcode.com/problems/complement-of-base-10-integer/description/">1009. Complement of Base 10 Integer</a>
 */
public class ComplementOfBaseTenInteger {


    public int bitwiseComplement(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();

        for(char c : binary.toCharArray()) {
            char opposite = c == '1'? '0':'1';
            sb.append(opposite);

        }

        int ans = Integer.parseInt(sb.toString(), 2);
        return ans;
    }

}
