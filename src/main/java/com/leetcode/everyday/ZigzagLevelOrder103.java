//package main.java.com.leetcode.everyday;
//
//import main.java.com.leetcode.binaryTree.TreeNode;
//
//import java.util.*;
//
///**
// * @description:
// * @author：wwei
// * @date: 2022/4/15
// */
//public class ZigzagLevelOrder103 {
//
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        Deque<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root);
//        int index = 1;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            List<Integer> tmp = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                TreeNode poll = queue.poll();
//                tmp.add(poll.value());
//                queue.offer(poll.left());
//                queue.offer(poll.right());
//            }
//            if ((index & 1) == 1) {
//                res.add(tmp);
//            } else {
//                Collections.reverse(tmp);
//                res.add(tmp);
//            }
//            index++;
//
//        }
//
//        return res;
//    }
//}
//
