package com.leetcode.everyday;

public class search {


    /**
     * 统计一个数字在排序数组中出现的次数。
     *
     * @param args
     */
    public static void main(String[] args) {

    }


    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int leftNum = nums[left];
            int rightNum = nums[right];
            if (leftNum == target && rightNum == target) {
                break;
            }
            if (leftNum < target) {
                left++;
            }
            if (rightNum > target) {
                right++;
            }
        }
        return right - left + 1;

    }

}
