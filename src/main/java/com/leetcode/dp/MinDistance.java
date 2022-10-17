package com.leetcode.dp;

/**
 * 72. 编辑距离
 */
public class MinDistance {
    public static void main(String[] args) {

    }

    public static int minDistance(String word1, String word2) {
        int table[][] = new int[word1.length() + 1][word2.length() + 1];

        for (int col = 1; col < table[0].length; col++) {
            table[0][col] = col;
        }

        for (int row = 1; row < table.length; row++) {
            table[row][0] = row;
        }
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = min(table[i - 1][j - 1], table[i][j - 1], table[i - 1][j]) + 1;
                }
            }
        }
        return table[table.length - 1][table[table.length - 1].length - 1];
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }


    public static int minDistance2(String word1, String word2) {
        int table[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int col = 0; col < table.length; col++) {
            table[0][col] = col;
        }
        for (int row = 0; row < table[0].length; row++) {
            table[row][0] = row;
        }
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = min(table[i - 1][j] + 1, table[i][j - 1] + 1, table[i - 1][j - 1] + 1);
                }
            }

        }
        return table[table.length - 1][table[table.length - 1].length - 1];
    }
}
