package main.java.com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Nsum {

    public static void main(String[] args) {
        checkInclusion("ab", "eidbaooo");
    }

//    public int[] twoSum(int[] nums, int target) {
//        if (nums.length < 2) return new int[]{};
//        int[] res = new int[nums.length - 1];
//        Arrays.sort(nums);
//        int start = 0, end = nums.length - 1;
//        while (start < end) {
//            int sum = nums[start] + nums[end];
//            if (target > sum) {
//                start++;
//            } else if (target < sum) {
//                end--;
//            } else {
//
//            }
//        }
//
//    }

    public static boolean checkInclusion(String t, String s) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) valid++;
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size())
                    return true;
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(c, window.getOrDefault(c, 0) - 1);
                }
            }
        }
        return false;
    }


    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int right = 0, left = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.getOrDefault(c, 0) > 1) {
                char d = s.charAt(left);
                left++;
                int dcount = window.getOrDefault(d, 0) == 0 ? 0 : window.getOrDefault(d, 0) - 1;
                window.put(d, dcount);
            }
            res = Math.max(res, right - left);
        }
        return res;

    }

}

