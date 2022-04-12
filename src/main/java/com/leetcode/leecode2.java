package main.java.com.leetcode;

import java.util.*;

public class leecode2 {
    List<String> res = new ArrayList<>();
    Integer max = 0;


    /**
     * 填充左括号以后填充右括号
     * 剩余左括号总数要小于等于右括号
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        getParenthesis("", n, n);
        return res;
    }

    private void getParenthesis(String str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left == right) {
            getParenthesis(str + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                getParenthesis(str + "(", left - 1, right);
            }
            getParenthesis(str + ")", left, right - 1);
        }

    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    public boolean isValidBST(TreeNode root) {
        return inorder(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    private boolean inorder(TreeNode node, long lower, long upper) {
        if (node == null) return true;
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return inorder(node.left, lower, node.val) && inorder(node.right, node.val, upper);
    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;

            }
            ans++;
        }
        return ans;
    }


    public int maxDept2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDept2(root.left);
        int right = maxDept2(root.right);
        return Math.max(left, right) + 1;
    }


    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder builder = new StringBuilder().append("");
        getParenthesis2(builder, n, n, ans);
        return ans;
    }

    private void getParenthesis2(StringBuilder s, int right, int left, List<String> ans) {
        if (right == 0 && left == 0) {
            ans.add(s.toString());
            return;
        }
        if (right == left) {
            getParenthesis2(s.append("("), right, left - 1, ans);
        } else if (left < right) {
            if (left > 0) {
                getParenthesis2(s.append("("), right, left - 1, ans);
            }
            getParenthesis2(s.append(")"), right - 1, left, ans);
        }
    }


    /**
     * 三数之和
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (nums[l] == nums[l + 1]) l++;
                    while (nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }else if (sum < 0) l++;
                else if (sum > 0) r--;
            }
        }
        return ans;
    }


    /**
     * 两个数组合并
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }





    public static void main(String[] args) {
        leecode2 leecode2 = new leecode2();
    }


}

