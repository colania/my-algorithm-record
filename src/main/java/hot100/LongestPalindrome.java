package main.java.hot100;

import java.util.Arrays;

/**
 * @description:
 * @author：wwei
 * @date: 2022/3/16
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int maxLen = 1;
        int begin = 0;
        int length = s.length();
        char[] chars = s.toCharArray();
        if (length == 1) {
            return s;
        }
        if (length == 2) {
            if (chars[0] == chars[1]) {
                return s;
            }
        }
        boolean[][] dp = new boolean[length][length];
        for (int Len = 2; Len <= length; Len++) {
            for (int left = 0; left < length; left++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int right = left + Len - 1;
                // 如果右边界越界，就可以退出当前循环
                if (right > length) {
                    break;
                }
                if (chars[right] != chars[left]) {
                    dp[left][right] = false;
                } else {
                    if (right - left < 3) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    begin = left;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    public static String longestPalindrome2(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return "";
        }

        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
            return s;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        int maxLen = 0;
        boolean[][] dp = new boolean[length][length];
        int start = 0;
        for (int l = 2; l < length; l++) {
            //左指针
            for (int left = 0; left < length; left++) {
                int right = left + l - 1;
                if (right > left) {
                    break;
                }
                if (chars[left] != chars[right]) {
                    dp[left][right] = false;
                } else {
                    if (right - left < 3) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }

                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
            }

        }
        return s.substring(start, start + maxLen);
    }
}
