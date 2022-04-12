package main.java.com.leetcode.everyday;

import java.util.Arrays;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/12
 */
public class SortColors75 {

    public static void main(String[] args) {
        sortColors();
    }

    public static void sortColors() {
        int[] ar = {1, 1, 2, 0, 2, 1, 0, 0};
        sort(ar, 0, ar.length - 1);
        System.out.println(Arrays.toString(ar));
    }

    public static void sort(int[] nums, int low, int high) {
        if (low < high) {
            int index = partition(nums, low, high);
            sort(nums, low, index - 1);
            sort(nums, index + 1, high);
        }
    }

    //找基准
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //找到left比基准大，right比基准小，进行交换
            if (left < right) {
                swap(arr, left, right);
            }
        }
        //第一轮完成，让left和right重合的位置和基准交换，返回基准的位置
        swap(arr, startIndex, left);
        return left;
    }

    //两数交换
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
