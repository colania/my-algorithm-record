package main.java.com.leetcode.dp;

import java.util.Arrays;

public class CoinChange {


    public static void main(String[] args) {
        System.out.println(solution1(new int[]{2}, 3));
    }

    /**
     * 思路 ：定义 F(i) 为组成金额 i 所需最少的硬币数量，
     * 假设在计算 F(i)之前，我们已经计算出 F(0)-F(i-1)的答案。 则 F(i)对应的转移方程应为
     * F(i) = Math.min(F(i),F(i-coin) +1 )
     */
    public static int solution1(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


}

