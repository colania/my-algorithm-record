package main.java.com.leetcode.everyday;

public class longestIncreasingPath {
    /**
     * dirs用于移动当前数字
     */
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int m, n;

    public static void main(String[] args) {
        int[][] param = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        longestIncreasingPath(param);
    }

    public static int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j, dp));
            }
        }
        return res;
    }

    public static int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j];
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row >= 0 && row < m && col >= 0 && col < n && matrix[i][j] < matrix[row][col]){
                dp[i][j] = Math.max(dp[i][j],dfs(matrix,row,col,dp)+1);
            }
        }
        return dp[i][j];
    }

    //最长子序列

}
