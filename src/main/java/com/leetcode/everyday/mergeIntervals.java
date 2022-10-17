package com.leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description:
 * @author：wwei
 * @date: 2022/3/11
 */
public class mergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;

        List<int[]> list = new ArrayList<>();
        //根据数组区间左端点排序

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= right){
                if (intervals[i][0] < left){
                    left = intervals[i][0];
                }
                //左右不变
            }else {
                right = intervals[i][1];
                if (intervals[i][0]< left){
                    left = intervals[i][0];
                }
                if (intervals[i][0] > right){
                    list.add(new int[]{left,right});
                    left = intervals[i][0];
                    right = intervals[i][1];
                }
            }

        }
        return list.toArray(new int[intervals.length][]);
    }

}
