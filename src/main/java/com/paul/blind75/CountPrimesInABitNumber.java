package com.paul.blind75;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/">762. Prime Number of Set Bits in Binary Representation</a>
 *
 */
public class CountPrimesInABitNumber {

    private static final Map<Integer, Boolean> primes = new HashMap<>();

    public static void main(String[] args) {
        int left = 6;
        int right = 10;

        int res = countPrimeSetBits(left, right);
        System.out.println(res);

    }

    public static int countPrimeSetBits(int left, int right) {
        int primeCounter = 0;
        for (int i = left; i <= right; i++) {
            String binary = Integer.toBinaryString(i);
            int count = 0;
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    count++;
                }
            }
            if (primes.getOrDefault(count, false)) {
                primeCounter++;
            } else if (isPrime(count)) {
                primeCounter++;
                primes.put(count, true);
            } else {
                primes.put(count, false);
            }
        }

        return primeCounter;

    }

    public static boolean isPrime(int n) {
        if (n == 1)
            return false;

        if (n <= 3)
            return true;

        int sqrt = (int) Math.sqrt(n) + 1;

        for (int i = 2; i < sqrt; i++) {

            if (n % i == 0) {
                return false;
            }

        }

        return true;
    }
}
