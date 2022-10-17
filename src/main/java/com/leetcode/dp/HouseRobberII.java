package com.leetcode.dp;

public class HouseRobberII {


    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1, 3, 5, 7}));
    }


    public static int rob(int[] nums) {
        int start0 = dp(nums, 0, nums.length - 2);
        int start1 = dp(nums, 1, nums.length - 1);

        return Math.max(start0, start1);
    }

    private static int dp(int[] nums, int start, int end) {
        int n = nums.length;
        int dp_i_1 = 0, dp_i_2 = 0;
        int dp_i = 0;
        for (int i = end; i >= start; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }

}
