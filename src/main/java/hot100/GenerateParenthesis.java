package main.java.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：wwei
 * @date: 2022/3/29
 */
public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recursive(n, result, 0, 0, new StringBuilder());
        return result;
    }

    public static void recursive(int n, List<String> list, int open, int close, StringBuilder sb) {
        if (sb.length() == n * 2) {
            list.add(sb.toString());
        }
        if (open < n) {
            sb.append('(');
            recursive(n, list, open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (open > close) {
            sb.append(')');
            recursive(n, list, open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
