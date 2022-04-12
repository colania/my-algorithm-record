package main.java.hot100;

import main.java.com.leetcode.leecode2.*;

/**
 * @description:
 * @author：wwei
 * @date: 2022/3/28
 */
public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode list3 = new ListNode(0);
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list3.next = list1;
                list3 = list3.next;
                list1 = list1.next;
            } else {
                list3.next = list2;
                list3 = list3.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            list3.next = list1;
        }
        if (list2 != null) {
            list3.next = list2;
        }
        return list3;
    }

}
