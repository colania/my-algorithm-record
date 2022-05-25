package main.java.com.leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/29
 */
public class ThreeSum15 {

    public static void main(String[] args) {
        ThreeSum15 threeSum15 = new ThreeSum15();
        System.out.println(threeSum15.threeSum(new int[]{0, 0, 0, 0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int right = nums.length - 1;
            int left = i + 1;
            while (left < right) {
                if (left - 1 > i && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (right + 1 < nums.length && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
