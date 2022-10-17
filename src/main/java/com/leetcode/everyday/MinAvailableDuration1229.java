package com.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/27
 */
public class MinAvailableDuration1229 {

    public int[] minAvailableDuration(int[][] a, int[][] b, int target) {
        int ap = 0;
        int bp = 0;
        List<int[]> list = new ArrayList<>();
        while (ap < a.length && bp < b.length) {
            int left = Math.max(a[ap][0], b[bp][0]);
            int right = Math.min(a[ap][1], b[bp][1]);
            if (left <= right) {
                list.add(new int[]{left, right});
            }
            if (a[ap][1] < b[bp][1]) {
                ap++;
            } else {
                bp++;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            if (ints[1] - ints[0] >= target) {
                return ints;
            }
        }
        return new int[0];
    }
}
