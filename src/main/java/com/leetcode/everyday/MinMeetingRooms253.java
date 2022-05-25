package main.java.com.leetcode.everyday;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/28
 */
public class MinMeetingRooms253 {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Deque<Integer> queue = new LinkedList<>();
        int max = 1;
        for (int[] inter : intervals) {
            while (queue.size() > 0 && inter[0] >= queue.peek()) {
                queue.pop();
            }
            queue.offer(inter[1]);
            max = Math.max(max, queue.size());
        }
        return max;
    }
}
