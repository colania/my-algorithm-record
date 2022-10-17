package com.leetcode.dp;

/**
 * @description:
 * @author：wwei
 * @date: 2022/3/23
 */
public class WaterTrap {

    public static void main(String[] args) {

    }

    public static int trap(int[] height) {
        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        int leftH = height[0];
        int rightH = height[height.length - 1];
        while (left < right) {
            if (leftH < rightH) {
                if (leftH < height[left + 1]) {
                    leftH = height[left + 1];
                } else {
                    sum += leftH - height[left + 1];
                }
                left++;
            } else {
                if (rightH >= height[right - 1]) {
                    rightH = height[right - 1];
                } else {
                    sum += rightH - height[right - 1];
                }
                right--;
            }
        }
        return sum;
    }
}
