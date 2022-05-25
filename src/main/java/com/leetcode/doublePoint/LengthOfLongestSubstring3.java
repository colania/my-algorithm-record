package main.java.com.leetcode.doublePoint;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/28
 */
public class LengthOfLongestSubstring3 {
    public static void main(String[] args) {
        LengthOfLongestSubstring3 lengthOfLongestSubstring3 = new LengthOfLongestSubstring3();
        System.out.println(lengthOfLongestSubstring3.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                Integer location = map.get(c);
                left = Math.max(left,location + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - left + 1);

        }
        return max;
    }
}
