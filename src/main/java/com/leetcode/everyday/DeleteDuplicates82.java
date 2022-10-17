package com.leetcode.everyday;

import com.leetcode.leecode2.ListNode;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/29
 */
public class DeleteDuplicates82 {

    public static void main(String[] args) {
        DeleteDuplicates82 dele = new DeleteDuplicates82();
        dele.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, null))))));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int deleteVal = cur.next.val;
                while (cur.next != null && cur.next.val == deleteVal) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }


    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int deleteVal = cur.next.val;
                while (cur.next != null && cur.next.val == deleteVal) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
