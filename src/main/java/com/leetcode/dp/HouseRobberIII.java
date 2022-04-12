package main.java.com.leetcode.dp;//package com.leetcode.dp;
//
//import com.example.leecode.leecode2.TreeNode;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class HouseRobberIII {
//    private static Map<TreeNode, Integer> cache = new HashMap<>();
//
//    public static void main(String[] args) {
//
//    }
//
//    public static int rob(TreeNode root) {
//        if (cache.containsKey(root)) {
//            return cache.get(root);
//        }
//
//        int do_it = root.getVal()
//                + (root.getLeft() == null ? 0 : rob(root.getLeft().getLeft()) + rob(root.getLeft().getRight()))
//                + (root.getRight() == null ? 0 : rob(root.getRight().getLeft()) + rob(root.getRight().getRight()));
//
//        int not_do = rob(root.getLeft()) + rob(root.getRight());
//        int res = Math.max(do_it, not_do);
//        cache.put(root, res);
//        return res;
//
//    }
//}
