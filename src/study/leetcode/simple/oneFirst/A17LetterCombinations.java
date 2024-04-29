package study.leetcode.simple.oneFirst;

import study.TimingTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        method17.run("22");
    }
}
class method17 extends TimingTemplate {

    @Override
    protected Object method(Object str) {
        String s = (String) str;
        HashMap<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<Integer> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int num = Integer.parseInt(String.valueOf(s.charAt(i)));
            list.add(num);
        }
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            String s1 = map.get(num);
            String res = "";
            for (int j = i+1; j < list.size(); j++) {
                num = list.get(j);
                String s2 = map.get(num);
                res = res+s1.charAt(k)+s2.charAt(l);
                for (int k = 0; k < s1.length(); k++) {
                    for (int l = 0; l < s2.length(); l++) {
                        list2.add(res);
                    }
                }
            }
        }

        return list2;
    }
}
