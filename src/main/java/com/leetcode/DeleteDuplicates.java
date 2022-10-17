package com.leetcode;


/**
 * @description:
 * @author：wwei
 * @date: 2022/3/23
 */
public class DeleteDuplicates {

    public static leecode2.ListNode deleteDuplicates(leecode2.ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        leecode2.ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
