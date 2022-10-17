package com.leetcode.everyday;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/30
 */
public class LongestPalindrome5 {

    public static void main(String[] args) {
        LongestPalindrome5 longestPalindrome5 = new LongestPalindrome5();
        System.out.println(longestPalindrome5.longestPalindrome("babad"));
    }

    private String palindrome2(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        String maxStr = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String s1 = palindrome2(s, i, i);
            String s2 = palindrome2(s, i, i + 1);
            String imax = s1.length() > s2.length() ? s1 : s2;
            maxStr = imax.length() > maxStr.length() ? imax : maxStr;
        }
        return maxStr;
    }


    public String longestPalindromeDp(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(r) == s.charAt(l) && (dp[r + 1][l - 1] || r - l <= 2)) {
                    dp[r][l] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }

            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}


