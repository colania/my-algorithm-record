package com.leetcode;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/1
 */
public class NextPermutation {
    public static List<List<Integer>> res = new ArrayList<>();

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {

    }

    public static void nextPermutation(int[] nums) {
        List<Integer> route = new ArrayList<>();
        for (int num : nums) {
            route.add(num);
        }
        recursion(route, nums, 0);
    }

    public static void recursion(List<Integer> route, int[] nums, int first) {
        if (first == nums.length - 1) {
            res.add(new ArrayList<>(route));
            return;
        }
        for (int i = first; i < nums.length - 1; i++) {
            Collections.swap(route, first, i);
            recursion(route, nums, first + 1);
            Collections.swap(route, i, first);
        }
    }


}
