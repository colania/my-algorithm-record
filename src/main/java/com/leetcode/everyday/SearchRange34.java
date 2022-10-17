package com.leetcode.everyday;

import java.util.Arrays;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/7
 */
public class SearchRange34 {

    public static void main(String[] args) {
        System.out.println(or(new int[]{3,0,1}));
//        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 2)));
    }

    public static int or(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        if (nums.length == 0) {
            return new int[]{start, end};
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{start, end};
            }
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                start = mid;
                while (start >= left && nums[start] == target) {
                    start--;
                }
                start += 1;
                end = mid;
                while (end <= right && nums[end] == target) {
                    end++;
                }
                end -= 1;
                break;
            }
        }
        return new int[]{start, end};
    }

}
