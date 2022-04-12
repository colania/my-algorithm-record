package main.java.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author：wwei
 * @date: 2022/3/15
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int max = -1;
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
            int right = i;
            while (right + 1 < chars.length && !set.contains(chars[right + 1])) {
                right++;
                set.add(chars[right]);
            }
            max = Math.max(max, right - i + 1);
            set.clear();
        }
        return max;
    }
}
