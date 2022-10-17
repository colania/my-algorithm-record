package com.leetcode;//package com.leetcode;
//
//import com.example.leecode.leecode2.TreeNode;
//import org.springframework.util.CollectionUtils;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Recursion {
//
//    public static void main(String[] args) {
//        List<String> resultList = new ArrayList<>();
//        resultList.add("aa");
//        resultList.add("bb");
//        resultList.add("cc");
//        resultList.add("dd");
//        resultList.add("ee");
//        resultList.add("ff");
//        resultList.add("gg");
//        resultList.add("hh");
//        int size = CollectionUtils.isEmpty(resultList) ? 0 : resultList.size();
//        if (size == 0){
//            return ;
//        }
//        System.out.println(resultList.subList(0, Math.min(size, 7)));
//    }
//
//
//    /**
//     * problem:70
//     * 爬n层楼梯 f(n) = f(n-1) + f(n-2)
//     * 时间复杂度n²
//     *
//     * @param n
//     * @return
//     */
//    public static int climbStairs1(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        return climbStairs1(n - 1) + climbStairs1(n - 2);
//    }
//
//    /**
//     * 使用一个数组保存递归中的元素，减少递归次数
//     *
//     * @param n
//     * @return
//     */
//    public static int climbStairs2(int n, int[] sum) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        if (sum[n] != 0) {
//            return sum[n];
//        }
//        sum[n] = climbStairs1(n - 1) + climbStairs1(n - 2);
//        return sum[n];
//    }
//
//    /**
//     * problem:22 括号生成
//     */
//    public static List<String> generateParenthesis(int n) {
//        List<String> res = new ArrayList<>();
//        String s = "";
//        buildParenthesis(n, n, res, s);
//        return res;
//    }
//
//    private static void buildParenthesis(int left, int right, List<String> res, String s) {
//        if (left == 0 && right == 0) {
//            res.add(s);
//            return;
//        }
//        if (left == right) {
//            buildParenthesis(left - 1, right, res, s + "(");
//        } else if (left < right) {
//            if (left > 0) {
//                buildParenthesis(left - 1, right, res, s + "(");
//            }
//            buildParenthesis(left, right - 1, res, s + ")");
//        }
//    }
//
//
//    /**
//     * 226. 翻转二叉树
//     * 其实就是左右子树互换
//     *
//     * @param root
//     * @return
//     */
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode left = root.left;
//        root.left = invertTree(root.right);
//        root.right = invertTree(left);
//        return root;
//    }
//
//
//    /**
//     * 50 实现 pow(x, n)
//     * 分治：栈溢出
//     */
//    public static double myPow(double x, int n) {
//        if (n == 0 || x == 1) {
//            return 1.0;
//        }
//        if (x == 0) {
//            return 0;
//        }
//        if (n < 0) {
//            x = 1 / x;
//            n = -n;
//        }
//        return getPow(x, n);
//    }
//
//    private static double getPow(double x, long n) {
//        if (n == 1) {
//            return x;
//        }
//        double total = getPow(x, n / 2);
//        return n % 2 == 0 ? total * total : total * total * x;
//
//    }
//
//    public static double myPow2(double x, int n) {
//        long N = n;
//        return N >= 0 ? getPow(x, N) : 1.0 / getPow2(x, -N);
//    }
//
//    private static double getPow2(double x, long n) {
//        if (n == 0) return 1.0;
//        double y = getPow2(x, n / 2);
//        return n % 2 == 0 ? y * y : y * y * x;
//    }
//
//
//    /**
//     * 169 多数元素
//     *
//     * @param nums
//     * @return
//     */
//    public static int majorityElement(int[] nums) {
//        int ret = nums[0];
//        int count = 1;
//        for (int num : nums) {
//            if (num != ret) {
//                count--;
//                if (count == 0) {
//                    count = 1;
//                    ret = num;
//                }
//            } else {
//                count++;
//            }
//        }
//        return ret;
//    }
//
//
//    public static int majorityElement2(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }
//
//    public static int majorityElement3(int[] nums) {
//        return split(nums, 0, nums.length - 1);
//    }
//
//    private static int split(int[] nums, int left, int right) {
//        if (left == right) {
//            return nums[left];
//        }
//        int mid = (right - left) / 2 + left;
//        int leftMajor = split(nums, left, mid);
//        int rightMajor = split(nums, mid + 1, right);
//        if (leftMajor == rightMajor) {
//            return leftMajor;
//        }
//        return merge(nums, leftMajor, rightMajor, left, right);
//    }
//
//    private static int merge(int[] nums, int leftMajor, int rightMajor, int left, int right) {
//        int leftCount = 0;
//        int rightCount = 0;
//        for (int num : nums) {
//            if (leftMajor == num) {
//                leftCount++;
//                continue;
//            } else if (rightMajor == num) {
//                rightCount++;
//            }
//        }
//        return leftCount > rightCount ? leftMajor : rightMajor;
//    }
//
//
//}
