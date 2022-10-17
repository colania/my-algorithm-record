package com.leetcode.everyday;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/20
 */
public class LongestValidParentheses32 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")(((((()())()()))()(()))("));
    }

    public static int longestValidParentheses(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Deque<Integer> queue = new LinkedList<>();
        int length = chars.length;
        queue.offer(0);
        int count = 1;
        while (count < length) {
            Integer peek = queue.peek();
            if (peek == null) {
                queue.push(count);
            } else {
                if (match(peek, count, chars)) {
                    queue.pop();
                } else {
                    queue.push(count);
                }
            }
            count++;
        }
        int max = 0;
        if (queue.size() == 0) {
            return s.length();
        }
        Integer last = queue.pop();
        if (queue.size() == 0) {
            if (last == length - 1) {
                max = length - (length - last);
            } else if (last == 0) {
                max = length - 1;
            } else {
                max = last > length - last - 1 ? last : length - last - 1;
            }
        } else {
            while (!queue.isEmpty()) {
                Integer pop = queue.pop();
                max = Math.max(max, last - pop) - 1;
                last = pop;
            }

        }
        return max;

    }

    public static boolean match(Integer a, Integer b, char[] chars) {
        if ((chars[a] == '(' && chars[b] == ')')) {
            return true;
        }

        return false;
    }
}
