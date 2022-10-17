package com.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：wwei
 * @date: 2022/5/5
 */
public class FindKthLargest215 {


    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        recall(nums, 0, res, new ArrayList<>(), used);
        return res;
    }


    public void recall(int[] nums, int count, List<List<Integer>> res, List<Integer> arr, boolean[] used) {
        if (count == nums.length) {
            res.add(new ArrayList<>(arr));
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                arr.add(nums[i]);
                used[i] = true;
                recall(nums, count + 1, res, arr,used);
                used[i] = false;
                arr.remove(arr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        FindKthLargest215 findKthLargest215 = new FindKthLargest215();
        System.out.println(findKthLargest215.permute(new int[]{1, 2, 3}));
    }

    public int findKthLargest(int[] nums, int k) {
        quicksort(nums, 0, nums.length - 1);
        int index = nums.length - k;
        for (int i = 0; i < nums.length; i++) {
            if (i == index) {
                return nums[index];
            }

        }
        return 0;
    }

    public void quicksort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(nums, left, right);
        quicksort(nums, left, partition - 1);
        quicksort(nums, partition + 1, right);

    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left;
        int r = right;
        while (l != r) {
            while (l < r && nums[r] > pivot) {
                r--;
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            if (l < r) {
                swap(nums, l, r);
            }
        }
        swap(nums, left, l);
        return l;
    }

    public void swap(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;

    }
}
