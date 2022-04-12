package main.java.com.leetcode.everyday;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/6
 */
public class MaxArea11 {

    public static void main(String[] args) {
        ThreadLocal.withInitial(()->0);
        System.out.println(maxArea(new int[]{1, 8, 6}));
    }

    public static int maxArea(int[] height) {
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int max = 0;
        while (left < right) {
            int val= (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max,val);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }


}
