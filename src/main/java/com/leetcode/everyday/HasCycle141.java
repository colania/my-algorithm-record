package com.leetcode.everyday;

import com.leetcode.leecode2.ListNode;

import java.util.List;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/18
 */
public class HasCycle141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || slow == null) {
                return false;
            }
            if (fast.next == null) {
                return false;
            }
            if (fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
