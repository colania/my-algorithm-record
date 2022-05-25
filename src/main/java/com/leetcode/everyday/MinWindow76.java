package main.java.com.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/13
 */
public class MinWindow76 {

    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }

    public static String minWindow(String s, String t) {
        char[] tchars = t.toCharArray();
        //首先创建的是need数组表示每个字符在t中需要的数量，用ASCII码来保存
        int[] need = new int[128];
        for (char tchar : tchars) {
            need[tchar]++;
        }
        int winLen = Integer.MAX_VALUE;
        int winStart = 0;
        int left = 0, right = 0;
        //当次遍历中还需要几个字符才能够满足包含t中所有字符的条件，最大也就是t的长度
        int count = tchars.length;
        while (right <= s.length() - 1) {
            char c = s.charAt(right);
            if (need[c] > 0) {
                count--;
            }
            need[c]--;

            if (count == 0) {
                while (left < right && need[s.charAt(left)] < 0) {
                    need[s.charAt(left)]++;
                    left++;
                }
                if (right - left + 1 < winLen) {
                    winLen = right - left + 1;
                    winStart = left;
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(left)]++;
                left++;
                count++;
            }
            right++;
        }
        return winLen == Integer.MAX_VALUE ? "" : s.substring(winStart, winStart + winLen);
    }
}
