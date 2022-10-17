package com.leetcode;

/**
 * @description:
 * @author：wwei
 * @date: 2022/3/31
 */
public class WaterTrap {

    public static int trap(int[] height) {
        int n = height.length - 1;
        int left = 0;
        int right = n;
        int sum = 0;
        int lMax = 0, rMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > lMax) {
                    lMax = height[left];
                } else {
                    sum += lMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rMax) {
                    rMax = height[right];
                } else {
                    sum += rMax - height[right];
                }
                right--;
            }
        }
        return sum;
    }
}
