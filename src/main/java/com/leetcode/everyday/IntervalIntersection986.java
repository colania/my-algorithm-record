package main.java.com.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/27
 */
public class IntervalIntersection986 {

    public static void main(String[] args) {
        IntervalIntersection986 intervalIntersection986 = new IntervalIntersection986();
        System.out.println(intervalIntersection986.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}));
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right = Math.min(firstList[i][1], secondList[j][1]);
            if (left <= right) {
                res.add(new int[]{left, right});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[0][0]);
    }
}
