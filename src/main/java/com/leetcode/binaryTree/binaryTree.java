package com.leetcode.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class binaryTree {


    public static void main(String[] args) {

    }

    // 记录所有子树以及出现的次数
    public static HashMap<String, Integer> memo = new HashMap<>();
    // 记录重复的子树根节点
    public static LinkedList<TreeNode> res = new LinkedList<>();

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    public static String traverse(TreeNode root) {

        if (root == null) {
            return "0";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + root.value;
        Integer orDefault = memo.getOrDefault(subTree, 0);
        if (orDefault == 1) {
            res.add(root);
        }
        memo.put(subTree, ++orDefault);
        return subTree;
    }



}
