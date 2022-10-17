package com.leetcode.everyday;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/8
 */
public class CanJump {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        int length = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= length) {
                length = i;
            }
        }
        return length == 0 ;
    }


}
