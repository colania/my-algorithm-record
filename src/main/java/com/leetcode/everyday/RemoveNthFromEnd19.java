package com.leetcode.everyday;

import com.leetcode.leecode2.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/20
 */
public class RemoveNthFromEnd19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0, head);
        Deque<ListNode> queue = new LinkedList<>();
         ListNode cur= node;
        while (cur != null) {
            queue.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            queue.pop();
        }
        ListNode poll = queue.peek();
        poll.next = poll.next.next;
        return node.next;
    }

}
