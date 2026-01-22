package com.paul.google.week4;


/**
 * <a href="https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/">475. Final Prices With a Special Discount in a Shop</a>
 */
public class FinalPricesSpecialDiscountShop {

    public int[] finalPrices(int[] prices) {
        // 8,4,6,2,3
        // 4,2,4,2,3

        //O(n)
        //8,9,10,11,12
        //0,0,0,0,0,0

        int len = prices.length;
        int[] ans = new int[len];

        for(int i = 0; i < len; i++) {

            int discount = prices[i];

            for(int j = i + 1; j < len; j++) {

                if (discount >= prices[j]) {
                    discount -= prices[j];
                    break;
                }
            }

            ans[i] = discount;

        }

        return ans;
    }


}
