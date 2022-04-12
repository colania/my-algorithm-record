package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author：wwei
 * @date: 2022/3/31
 */
public class Permute {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> list = new ArrayList<List<Integer>>();

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> route = new ArrayList<>();
        for (int num : nums) {
            route.add(num);
        }
        backtrack(route, nums, 0);
        return list;
    }

    public static void backtrack(List<Integer> route, int[] nums, Integer first) {
        if (first == nums.length - 1) {
            list.add(new ArrayList<>(route));
            return;
        }
        for (int i = first; i < nums.length; i++) {
            Collections.swap(route, first, i);
            backtrack(route, nums, first + 1);
            Collections.swap(route, first, i);

        }
    }
}
