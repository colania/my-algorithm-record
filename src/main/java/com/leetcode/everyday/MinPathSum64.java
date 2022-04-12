package main.java.com.leetcode.everyday;

import com.sun.xml.internal.ws.policy.PolicyMapUtil;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/11
 */
public class MinPathSum64 {

    public static void main(String[] args) {
        int[][]grid = new int[2][3];
        grid[0][0]= 1;
        grid[0][1]= 2;
        grid[0][2]= 3;
        grid[1][0]= 4;
        grid[1][1]= 5;
        grid[1][2]= 6;
        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        int height = grid.length;
        int weight = grid[0].length;

        int[][] dp = new int[height][weight];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < weight; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < height; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < weight; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[height-1][weight - 1];
    }

}
