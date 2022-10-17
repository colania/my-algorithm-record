package com.leetcode;//package com.leetcode;
//
//import com.example.leecode.leecode2.TreeNode;
//
//import java.util.*;
//
//public class Dynamic {
//    public static void main(String[] args) {
//
//    }
//
//    /**
//     * 3. 无重复字符的最长子串
//     * 滑动窗口
//     */
//    public static int lengthOfLongestSubstring(String s) {
//        int length = s.length();
//        if (length == 0 || length == 1) {
//            return length;
//        }
//        Set<Character> set = new HashSet<>();
//        int right = -1;
//        int max = 0;
//        for (int i = 0; i < length; i++) {
//            if (i != 0) {
//                set.remove(s.charAt(i - 1));
//            }
//            while (right + 1 < length && !set.contains(s.charAt(right + 1))) {
//                set.add(s.charAt(right + 1));
//                ++right;
//            }
//            max = Math.max(max, right - i + 1);
//        }
//        return max;
//    }
//
//    /**
//     * 215. 数组中的第K个最大元素
//     * 先排序后找最大
//     */
//    public static int findKthLargest(int[] nums, int k) {
//        sort(nums, 0, nums.length);
//        return nums[nums.length - k];
//    }
//
//    public static void sort(int[] array, int lo, int hi) {
//        if (lo >= hi) {
//            return;
//        }
//        int index = getMiddle(array, lo, hi);
//        sort(array, lo, index - 1);
//        sort(array, index + 1, hi);
//    }
//
//    public static int getMiddle(int[] numbers, int low, int high) {
//        int temp = numbers[low]; //数组的第一个作为中轴
//        while (low < high) {
//            while (low < high && numbers[high] > temp) {
//                high--;
//            }
//            numbers[low] = numbers[high];//比中轴小的记录移到低端
//            while (low < high && numbers[low] < temp) {
//                low++;
//            }
//            numbers[high] = numbers[low]; //比中轴大的记录移到高端
//        }
//        numbers[low] = temp; //中轴记录到尾
//        return low; // 返回中轴的位置
//    }
//
//    /**
//     * 二叉树的锯齿形层序遍历
//     * DFS
//     *
//     * @param root
//     * @return
//     */
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        Deque<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root);
//        int index = 1;
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            List<Integer> tmp = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                TreeNode poll = queue.poll();
//                tmp.add(poll.val);
//                if (poll.left != null) {
//                    queue.offer(poll.left);
//                }
//                if (poll.right != null) {
//                    queue.offer(poll.right);
//                }
//            }
//            //当index为奇数时，就正向输出
//            if ((index & 1) == 1) {
//                res.add(tmp);
//            }
//            //当index偶位数时，就反向输出，即先调用一次reverse，再保存
//            else {
//                Collections.reverse(tmp);
//                res.add(tmp);
//            }
//            ++index;
//
//        }
//        return res;
//
//    }
//
//    /**
//     * @param obstacleGrid
//     * @return
//     */
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if (obstacleGrid == null || obstacleGrid.length == 0) {
//            return 0;
//        }
//
//        // 定义 dp 数组并初始化第 1 行和第 1 列。
//        int m = obstacleGrid.length, n = obstacleGrid[0].length;
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
//            dp[i][0] = 1;
//        }
//        for (int i = 0; i < m && obstacleGrid[0][i] == 0; i++) {
//            dp[0][i] = 1;
//        }
//        // 根据状态转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 进行递推。
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (obstacleGrid[i][j] == 1) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//            }
//        }
//        return dp[m - 1][n - 1];
//
//    }
//
//    /**
//     * 1143. 最长公共子序列
//     *
//     * @param text1
//     * @param text2
//     * @return
//     */
//    public int longestCommonSubsequence(String text1, String text2) {
//        int m = text1.length();
//        int n = text2.length();
//        int[][] dp = new int[m][n];
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        return dp[m][n];
//    }
//
//
//    /**
//     * 15. 二进制中1的个数
//     *
//     * @param n
//     * @return
//     */
//    public static int binaryGap(int n) {
//        int count = 0;
//        int last = 0;
//        String s = Integer.toBinaryString(n);
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '1') {
//                count = Math.max(count, i - last);
//                last = i;
//            }
//        }
//        return count;
//    }
//
//
//    public int climbStairs(int n) {
//        if (n == 1) {
//            return n;
//        }
//        int[] dp = new int[n];
//        dp[0] = 1;
//        dp[1] = 2;
//        for (int i = 2; i < n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n - 1];
//    }
//
//
//    /**
//     * 72. 编辑距离
//     * dp
//     */
//    public int minDistance(String word1, String word2) {
//        int n1 = word1.length();
//        int n2 = word2.length();
//        int[][] dp = new int[n1 + 1][n2 + 1];
//        // 第一行
//        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
//        //第一列
//        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;
//        for (int i = 0; i < n1; i++) {
//            for (int j = 0; j < n2; j++) {
//                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
//                }
//            }
//        }
//        return dp[n1][n2];
//    }
//}
