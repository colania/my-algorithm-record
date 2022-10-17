package com.leetcode.dp;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }


    /**
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i]> dp[j]){
                    dp[i] = Math.max(dp[i-1]+1 ,dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


}
