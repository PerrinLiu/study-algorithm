package study.leetcode.BFirst;

import java.util.ArrayList;
import java.util.List;

/**
 * b22生成括号
 *
 * @author llpy
 * @date 2024/05/05
 */
public class B22GenerateParenthesis {
    // 22. 括号生成 中等
    // 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

    // 示例 1：
    // 输入：n = 3
    // 输出：["((()))","(()())","(())()","()(())","()()()"]

    // 输入：n = 2
    // 输出：["(())","()()"]

    // 示例 2：
    // 输入：n = 1
    // 输出：["()"]
    //
    //
    // 提示：
    // 1 <= n <= 8
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(10);
        System.out.println(strings);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        getParenthesis(result, "", n, n);
        return result;
    }

    private static void getParenthesis(List<String> result, String s, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left == right) {
            s = s + "(";
            getParenthesis(result, s, left - 1, right);
        } else {
            if (left > 0) {
                String str = s + "(";
                getParenthesis(result, str, left - 1, right);
            }
            s = s + ")";
            getParenthesis(result, s, left, right - 1);
        }
    }

}
