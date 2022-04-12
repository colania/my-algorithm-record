package main.java.com.leetcode.dp;

import java.util.Arrays;
/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class HouseRobberI {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1, 3, 5, 1}));
    }


    public static int rob(int[] nums) {
        int[] sum = new int[nums.length];
        Arrays.fill(sum, -1);
        return dp(nums, 0, sum);
    }


    private static int dp(int[] nums, int start, int[] sum) {
        if (start >= nums.length) return 0;
        if (sum[start] != -1) {
            return sum[start];
        }
        sum[start] = Math.max(dp(nums, start + 1, sum), nums[start] + dp(nums, start + 2, sum));
        return sum[start];
    }

    public static int rob2(int[] nums) {
        int n = nums.length;
        // dp[i] = x 表示：
        // 从第 i 间房子开始抢劫，最多能抢到的钱为 x
        // base case: dp[n] = 0
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }

}
