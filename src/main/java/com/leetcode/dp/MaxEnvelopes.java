package com.leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        int[] height =new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    private int lengthOfLIS(int[] nums) {
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
