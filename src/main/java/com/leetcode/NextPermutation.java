package main.java.com.leetcode;

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

    public static int[] nextPermutation2(int[] nums) {
        //1.从后往前找，找到第一个nums[n]<nums[n+1]的数
        //2.从n+1开始，找到最小且比nums[n]大的值，交换
        //3.从n后的数字从小到大排列
        int[] res = new int[nums.length];
        int first = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[i - 1]) {
                first = i;
                break;
            }
        }
        if (first == -1) {
            for (int i = 0; i < nums.length; i++) {
                res[i] = res[nums.length - 1 - i];
            }

        }
        int min = 999;
        int second = nums.length;
        for (int i = first + 1; i < nums.length; i++) {
            if (nums[i] > nums[first]) {
                min = Math.min(min, nums[i]);
                second = i;
            }
        }
        int temporary = 999;
        temporary = nums[first];
        nums[first] = nums[second];
        nums[second] = temporary;

        Arrays.sort(nums, first + 1, nums.length - 1);
        return nums;
    }
}
