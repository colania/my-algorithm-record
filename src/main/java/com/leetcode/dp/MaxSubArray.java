package main.java.com.leetcode.dp;

import java.util.Arrays;

public class MaxSubArray {

    public static void main(String[] args) {
        maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }


    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,0);
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+ nums[i] , nums[i]);
            if (max< dp[i])max = dp[i];
        }
        return max;
    }


//    public static int maxSubArray(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, nums[0]);
//        int max = dp[0];
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
//            if (max < dp[i]){
//                max = dp[i];
//            }
//        }
//        return max;
//    }
}
