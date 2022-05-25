package main.java.com.leetcode.binaryTree;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/21
 */
public class NextNode extends TreeNode{
    TreeNode next;

    public NextNode(int value, TreeNode left, TreeNode right, TreeNode next) {
        super(value, left, right);
        this.next = next;
    }

    public TreeNode getNext() {
        return next;
    }

    public void setNext(TreeNode next) {
        this.next = next;
    }
}
