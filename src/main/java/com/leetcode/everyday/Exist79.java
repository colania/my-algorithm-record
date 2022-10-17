package com.leetcode.everyday;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/14
 */
public class Exist79 {
    private static int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static boolean exist(char[][] board, String word) {
        int length = board.length;
        int weight = board[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < weight; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] used = new boolean[length][weight];
                    used[i][j] = true;
                    if (dfs(board, word, i, j, used, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, boolean[][] used, int deep) {
        if (deep == word.length()) {
            return true;
        }
        for (int[] dir : direction) {
            int newi = i + dir[0];
            int newj = j + dir[1];

            if (!inArea(newi, newj, board.length, board[0].length)) {
                continue;
            }
            if (used[newi][newj]) {
                continue;
            }
            if (board[newi][newj] != word.charAt(deep)) {
                continue;
            }
            used[newi][newj] = true;
            if (dfs(board, word, newi, newj, used, deep + 1)) {
                return true;
            }
            used[newi][newj] = false;
        }
        return false;
    }

    private static boolean inArea(int x, int y, int height, int weight) {
        return x >= 0 && x < height && y >= 0 && y < weight;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
    }


}
