package leetcode_online_judge;

import utils.Utils;

public class BestTimeToBuyAndSellStock {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design
    an algorithm to find the maximum profit.
     */
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minBuy = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minBuy);
            minBuy = Math.min(minBuy, prices[i]);
        }

        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int size = prices.length;

        if (size<=1){
            return 0;
        }

        int min = prices[0];
        int max = prices[1] - min;
        for (int i = 2; i < size; i++) {

            if (min > prices[i-1]) {
                min = prices[i-1];
            }

            if (max < (prices[i]-min)) {
                max = prices[i]-min;
            }

        }


        return (max<0) ? 0 : max;
    }

    private static void test() {
        Utils.printTestln(maxProfit(new int[]{3,2,6,5,0,3}), 4);
    }

    public static void main(String[] args) {
        test();
    }
}
