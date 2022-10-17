package com.leetcode.everyday;

import com.leetcode.leecode2.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/29
 */
public class ReorderList143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            if (left == right){
                break;
            }
            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next = null;
        ConcurrentHashMap<String,String > hashMap = new ConcurrentHashMap();
        hashMap.put("a","a");
        hashMap.get("a");
    }
}
