package com.leetcode.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/26
 */
public class LongestConsecutive128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            int cur = num;
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            max = Math.max(cur - num + 1, max);
        }
        return max;
    }
}
