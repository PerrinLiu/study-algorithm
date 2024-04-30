package study.leetcode.simple.oneFirst;

import study.TimingTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * a17个字母组合
 *
 * @author llpy
 * @date 2024/04/29
 */
public class A17LetterCombinations {
//    17. 电话号码的字母组合   中等
//    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
//    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

    //    示例 1：
//    输入：digits = "23"
//    输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//    示例 2：
//
//    输入：digits = ""
//    输出：[]
    //    示例 3：
//    输入：digits = "2"
//    输出：["a","b","c"]
//
//    提示：
//            0 <= digits.length <= 4
//    digits[i] 是范围 ['2', '9'] 的一个数字。
    public static void main(String[] args) {
        TimingTemplate method17 = new method17();
        method17.run("23");
        TimingTemplate solution = new Solution();
        solution.run("234");
    }
}

class method17 extends TimingTemplate {

    @Override
    protected Object method(Object str) {
        String digits = (String) str;
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        //最终结果集
        List<String> res = new ArrayList<>();
        //遍历数字
        for (int i = 0; i < digits.length(); i++) {
            String param = map.get(digits.charAt(i));
            //每一次的结果集
            List<String> list = new ArrayList<>();
            //遍历数字对应的字符
            for (int j = 0; j < param.length(); j++) {
                String s = String.valueOf(param.charAt(j));
                //第一个数字不需要进行拼接，直接加入
                if (i == 0) {
                    res.add(s);
                    continue;
                }
                int k = 0;
                //将字符与最终结果集的所有值进行拼接成新的结果集
                while (res.size() > k) {
                    String newStr = res.get(k++) + s;
                    list.add(newStr);
                }
            }
            res = i != 0 ? list : res;
        }
        return res;
    }
}


class Solution extends TimingTemplate {
    @Override
    protected Object method(Object s) {
        String str = (String) s;
        return letterCombinations(str);
    }

    private static final Map<Character, String> DIGIT_MAP = new HashMap<>();

    static {
        DIGIT_MAP.put('2', "abc");
        DIGIT_MAP.put('3', "def");
        DIGIT_MAP.put('4', "ghi");
        DIGIT_MAP.put('5', "jkl");
        DIGIT_MAP.put('6', "mno");
        DIGIT_MAP.put('7', "pqrs");
        DIGIT_MAP.put('8', "tuv");
        DIGIT_MAP.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String digits, int index, StringBuilder combination, List<String> res) {
        if (index == digits.length()) {
            res.add(combination.toString());
            return;
        }
        String letters = DIGIT_MAP.get(digits.charAt(index));
        for (char letter : letters.toCharArray()) {
            combination.append(letter);
            backtrack(digits, index + 1, combination, res);
            combination.deleteCharAt(combination.length() - 1);
        }
    }


}