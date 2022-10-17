package com.leetcode;//package com.leetcode;
//
//import com.example.leecode.leecode2.TreeNode;
//
//import java.util.*;
//
//public class BinaryTree {
//    List<List<String>> res = new ArrayList<>();
//
//    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree();
//        System.out.println(binaryTree.letterCombinations("23"));
//    }
//
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        Deque<TreeNode> queue = new LinkedList();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int n = queue.size();
//            List<Integer> level = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                TreeNode node = queue.poll();
//                level.add(node.val);
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//            res.add(level);
//        }
//        return res;
//    }
//
//
//    public static List<Integer> largestValues(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        Deque<TreeNode> queue = new LinkedList();
//        if (root == null) {
//            return res;
//        }
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int n = queue.size();
//            Integer max = null;
//            for (int i = 0; i < n; i++) {
//                TreeNode node = queue.poll();
//                max = max == null ? node.val : Math.max(max, node.val);
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//            res.add(max);
//        }
//        return res;
//    }
//
//
//    /**
//     * 计算平方根
//     *
//     * @param x
//     * @return
//     */
//    public static int mySqrt(int x) {
//        int start = 0;
//        int end = x;
//        int ans = -1;
//        while (start <= end) {
//            int mid = (end - start) / 2 + start;
//            if (mid * mid <= x) {
//                ans = mid;
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//        return ans;
//    }
//
//
//    public static boolean isPerfectSquare(int num) {
//        int start = 1;
//        int end = num;
//
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            int t = num / mid;
//            if (t == mid) {
//                if (num % mid == 0) {
//                    return true;
//                }
//                start = mid + 1;
//            } else if (mid > t) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return false;
//    }
//
//
//    public int majorityElement(int[] nums) {
//        int length = nums.length;
//
//        if (length == 0) {
//            return -1;
//        }
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//
//    }
//
//    /**
//     * 17. 电话号码的字母组合
//     *
//     * @param digits
//     * @return
//     */
//    public List<String> letterCombinations(String digits) {
//        List<String> res = new ArrayList<>();
//        if (digits == null || digits.length() == 0) {
//            return res;
//        }
//        String[] phone = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        combine(digits, "", 0, phone, res, digits.length());
//        return res;
//    }
//
//    private void combine(String digits, String letter, int n, String[] phone, List<String> res, int length) {
//        if (n == length) {
//            res.add(letter);
//            return;
//        }
//        int c1 = Integer.parseInt(Character.toString(digits.charAt(n)));
//        String chars = phone[c1];
//        for (int i = 0; i < chars.length(); i++) {
//            char c = chars.charAt(i);
//            combine(digits, letter + c, n + 1, phone, res, length);
//        }
//
//    }
//
//
//    /**
//     * 51. N 皇后
//     *
//     * @param n
//     * @return
//     */
//    public List<List<String>> solveNQueens(int n) {
//        char[][] chessboard = new char[n][n];
//        for (char[] line : chessboard) {
//            Arrays.fill(line, '.');
//        }
//        backTrack(chessboard, n, 0);
//        return res;
//    }
//
//    private void backTrack(char[][] chessboard, int n, int row) {
//        if (row == chessboard.length) {
//            //将整副棋盘copy进res
//            List<String> copyBoard = new ArrayList<>();
//            for (char[] line : chessboard) {
//                copyBoard.add(String.valueOf(line));
//            }
//            res.add(copyBoard);
//            return;
//        }
//
//        //(1)遍历每个棋子位
//        for (int col = 0; col < n; col++) {
//            //(2)判断该棋位下'Q'是否合法
//            if (!isValid(chessboard, n, row, col))
//                continue;
//
//            //(3)回溯
//            chessboard[row][col] = 'Q';
//            backTrack(chessboard, n, row + 1);
//            chessboard[row][col] = '.';
//
//        }
//    }
//
//    //判断皇后落子是否合格：判断行(无需判断)、列、左上与右上
//    private boolean isValid(char[][] chessboard, int n, int row, int col) {
//        //判断列是否存在皇后
//        for (int r = 0; r < n; r++) {
//            if (chessboard[r][col] == 'Q')
//                return false;
//        }
//
//        //判断右上方（斜线）是否存在皇后
//        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
//            if (chessboard[i][j] == 'Q')
//                return false;
//        }
//
//        //判断左上方（斜线）是否存在皇后
//        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
//            if (chessboard[i][j] == 'Q')
//                return false;
//
//        //到此说明皇后落子合格
//        return true;
//    }
//
//
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Deque<String> queue = new LinkedList<String>();
//        queue.add(beginWord);
//        int layer = 1;
//        boolean[] marked = new boolean[wordList.size() + 1];//少不了标记
//        while (!queue.isEmpty()) {
//            String cur = queue.poll();
//            for (int i = 0; i < wordList.size(); i++) {
//                if (marked[i]) continue;
//                String dic = wordList.get(i);
//                if (change(cur, dic)) {
//                    if (dic == endWord) {
//                        return layer;
//                    }
//                    queue.add(dic);
//                    marked[i] = true;
//                }
//            }
//        }
//        return 0;
//    }
//
//    private boolean change(String cur, String dic) {
//        int diff = 0;
//        for (int i = 0; i < cur.length(); i++) {
//            if (cur.charAt(i) != dic.charAt(i)) diff++;
//        }
//        return diff == 1;
//    }
//}