package com.leetcode.dp;

import java.util.List;

/**
 * @description:
 * @author：wwei
 * @date: 2022/3/10
 */
public class Stock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        //dp[i][0] 表示在第i天时，手中有股票时的最大现金
        //dp[i][1]表示在第i天时，手中无股票的最大现金
        int[][] dp = new int[prices.length][2];
        //第0天时，如果买进股票，那么手里的钱为-price[0]
        //第0天时，如果没买进股票，那么手里的钱为0
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            //第i天，如果有股票时，可能为 上一天已经有的股票， 或者 上一天没有股票，今天买入
            //第i天，如果没有有股票时，可能为 上一天没有股票， 或者 上一天有股票，今天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }


}
