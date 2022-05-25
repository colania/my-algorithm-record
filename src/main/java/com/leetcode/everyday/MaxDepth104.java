package main.java.com.leetcode.everyday;

import main.java.com.leetcode.binaryTree.TreeNode;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/25
 */
public class MaxDepth104 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, null));
        MaxDepth104 maxDepth104 = new MaxDepth104();
        System.out.println(maxDepth104.maxDepth(root));

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
