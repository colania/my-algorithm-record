//package com.leetcode.everyday;
//
//import com.leetcode.binaryTree.NextNode;
//import com.leetcode.leecode2.*;
//
//import java.util.*;
//
///**
// * @description:
// * @author：wwei
// * @date: 2022/4/21
// */
//public class Connect116 {
//
//
//    public static List<Integer> list = new ArrayList<>();
//
//    public static void main(String[] args) {
//
//
//    }
//
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) {
//            return list;
//        }
//        Deque<TreeNode> queue = new LinkedList<>();
//        while (!queue.isEmpty() || root != null) {
//            if (root != null) {
//                queue.push(root);
//                root = root.getLeft();
//            }else {
//                TreeNode node = queue.poll();
//                list.add(node.getVal());
//                root = node.getRight();
//            }
//
//        }
//        return list;
//    }
//
//    public NextNode connect(NextNode root) {
//        if (root == null) {
//            return null;
//        }
//        Deque<NextNode> queue = new LinkedList<>();
//        queue.offer(root);
//        NextNode first = new NextNode(-1, null, null, null);
//        NextNode result = first;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                NextNode pop = queue.poll();
//                first.setNext(pop);
//                if (pop.getRight() != null) {
//                    queue.push((NextNode) pop.getRight());
//                }
//                if (pop.getLeft() != null) {
//                    queue.push((NextNode) pop.getLeft());
//                }
//            }
//            first.setNext(new NextNode(-1, null, null, null));
//            first = (NextNode) first.getNext();
//        }
//
//        return result;
//    }
//
//}
//
