package main.java.hot100;//package hot100;
//
//import java.util.ArrayDeque;
//import java.util.Deque;
//
///**
// * @description:
// * @author：wwei
// * @date: 2022/3/17
// */
//public class IsMatch {
//
//    public static boolean isMatch(String s, String p) {
//        if (!p.contains("*") && !p.contains(".") && !p.equals(s)) {
//            return false;
//        }
//        char[] sChar = s.toCharArray();
//        char[] pChar = p.toCharArray();
//        //flag 记录当前所在schar的位置
//        int flag = 0;
//        Deque<Integer> queue = new ArrayDeque<>();
//        queue.offer(0);
//        while (!queue.isEmpty()) {
//            Integer poll = queue.poll();
//            if (pChar[poll] == (sChar[flag + 1]) || pChar[poll] == ('.')) {
//                flag++;
//                queue.push(++poll);
//            } else if (pChar[poll] == '*') {
//                if (sChar[flag] == sChar[flag - 1]) {
//                    flag++;
//                } else {
//                    if (poll < pChar.length - 1) {
//                        poll++;
//                        queue.push(poll);
//                    } else {
//                        return false;
//                        break;
//                    }
//
//                }
//            }
//
//        }
//
//    }
//}

