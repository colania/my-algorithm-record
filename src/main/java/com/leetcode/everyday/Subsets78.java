package main.java.com.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/12
 */
public class Subsets78 {


    List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        recall(nums, 0, new ArrayList<>());
        return res;
    }

    public static void recall(int[] nums, int flag, List<Integer> array) {
        res.add(new ArrayList<>(array));
        for (int i = flag; i < nums.length; i++) {
            array.add(nums[i]);
            recall(nums, i + 1, array);
            array.remove(array.size() - 1);
        }
    }
}
