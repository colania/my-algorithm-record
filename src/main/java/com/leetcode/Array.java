package main.java.com.leetcode;


import java.util.*;

public class Array {


    /**
     * 350
     * 双循环解法
     *
     * @return
     */
    public static void intersect(int[] numa, int[] numb) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap();
        for (int b : numb) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        for (int a : numa) {
            Integer value = map.get(a);
            if (value != null && value > 0) {
                map.put(a, value - 1);
                result.add(a);
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
    }

    /**
     * 350 排序 双指针
     *
     * @param numa
     * @param numb
     */
    public static void intersectSort(int[] numa, int[] numb) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(numa);
        Arrays.sort(numb);
        int indexa = 0, indexb = 0;
        while (indexa < numa.length && indexb < numb.length) {
            if (numa[indexa] == numb[indexb]) {
                result.add(numa[indexa]);
                indexa++;
                indexb++;
            } else if (numa[indexa] > numb[indexb]) {
                indexb++;
            } else if (numa[indexa] < numb[indexb]) {
                indexa++;
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
    }


    /**
     * 买卖股票的最佳时机 II
     */
    private void Problem122(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i + 1] > prices[i]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        System.out.println(maxProfit);
    }

    /**
     * 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     */
    private void Problem189(int[] array, int k) {
        reverse(array);
        //todo
    }

    private int[] reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int a = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = a;
        }
        return array;
    }


    /**
     * 27
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度
     */
    private void problem27(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        System.out.println(i);
    }


    /**
     * 66 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     */
    private static int[] problem66(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0)
                return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    /**
     * 三数之和
     */
    private static void problem15(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int sum = nums[i] + nums[left] + nums[right];
            while (sum != 0) {
                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
                if (right <= left) {
                    break;
                }
                sum = nums[i] + nums[left] + nums[right];
            }
            if (left != right) {
                System.out.println("i = " + nums[i] + " left = " + nums[left] + " right = " + nums[right]);
            }

        }

    }


    private static double problem6(double coe, double length, double total) {
        if (length <= 0.001) {
            return total;
        }
        total += (coe + 1) * length;
        length *= coe;
        return problem6(coe, length, total);
    }

    private static void problem7() {
        List<String> list1 = new ArrayList<>();
        list1.add("1111");
        list1.add("2222");
        list1.add("3333");
        List<String> list2 = new ArrayList<>();
        list2.add("3333");
        list2.add("4444");
        list2.add("5555");
        list1.retainAll(list2);
        System.out.println(list1);

    }

    /**
     * 20. 有效的括号
     */
    private static boolean problem20(String s) {

        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Stack stack = new Stack<Character>();
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length()) {
                if (stack.isEmpty()) {
                    return true;
                }
                return false;
            }

            char word = s.charAt(i);
            if ('(' == word || '{' == word || '[' == word) {
                stack.push(word);
            }
            if (')' == word || '}' == word || ']' == word) {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = (char) stack.pop();
                if (pairs.get(word) == pop) {
                    continue;
                }
                return false;
            }
        }
        return false;
    }


    /**
     * 84. 柱状图中最大的矩形
     *
     * @param
     * @return
     */
    private static void problem84(int[] heights) {
        //在数组尾部加一个0，保证栈中所有元素弹出
        int n = heights.length;
        int[] new_heights = new int[n + 1];
        for (int i = 0; i < n; i++) {

            new_heights[i] = heights[i];
        }
        new_heights[n] = 0;
        Deque<Integer> stack = new ArrayDeque();
        int res = 0;
        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int height = new_heights[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    res = Math.max(res, i * height);
                } else {
                    res = Math.max(res, height * (i - stack.peek() - 1));
                }
            }
            stack.push(i);
        }
    }


    private static boolean problem242(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);

    }


    private static List problem49(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            List<String> list = result.get(s);
            if (list == null) {
                result.put(s, new ArrayList<>());
            }
            result.get(s).add(str);
        }
        return new ArrayList<List<String>>(result.values());

    }


    private static int[] problem1(int[] nums, int target) {
        int[] indexs = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                indexs[0] = i;
                indexs[1] = map.get(nums[i]);
            }
        }
        return indexs;
    }


    public List<Integer> problem94(TreeNode root) {
        /**
         * 中序遍历： 左中右
         */
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        Deque<TreeNode> stack = new ArrayDeque();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;

    }

    public void inorder(TreeNode root, List<Integer> res) {
        /**
         * 中序遍历： 左中右
         */
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);

    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public List<Integer> problem589_2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        return list;
    }


    public List<Integer> problem590(Node root) {
        Deque<Node> stack = new ArrayDeque();
        LinkedList<Integer> list = new LinkedList();
        if (root == null) {
            return list;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            list.addFirst(node.val);
            for (Node child : node.children) {
                if (child != null) {
                    stack.push(child);
                }
            }
        }
        return list;
    }


    public List<Integer> problem590_2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        for (int i = 0; i < root.children.size(); i++) {
            list.addAll(problem590_2(root.children.get(i)));
        }
        list.add(root.val);
        return list;

    }


    private class TreeNode {
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
    }


    /**
     *  递归代码模板
     *
     * public void recur(int level ,int param){
     *      终止条件
     *     if(level > MAX_LEVEL){
     *         return;
     *     }
     *
     *     处理业务
     *     process(level,param);
     *
     *     recur(level:level+1,param);
     * }
     */

    /**
     * 爬楼梯
     *
     * @param n
     * @return
     */
    public int problem70(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1, b = 2, temp;
        for (int i = 3; i <= n; i++) {
            temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }

    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }




    public static void main(String[] args) {
        int a = 1;
        if (a!=0 && a!= 1){
            System.out.println("Aaaaaaa");
        }

    }


}
