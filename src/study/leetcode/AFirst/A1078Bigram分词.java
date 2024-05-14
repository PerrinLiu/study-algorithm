package study.leetcode.AFirst;
/*
 * @lc app=leetcode.cn id=1078 lang=java
 *
 * [1078] Bigram 分词
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class A1078Bigram分词 {
    public static void main(String[] args) {
        String text = "alice is a good girl she is a good student";
        String first = "a", second = "good";
        String[] ocurrences = new A1078Bigram分词().findOcurrences(text, first, second);
        System.out.println(Arrays.toString(ocurrences));
    }

    public String[] findOcurrences(String text, String first, String second) {
        String[] split = text.split(" ");
        List<String> res = new ArrayList<>();
        for (int i = 0; i < split.length - 2; i++) {
            String one = split[i];
            String two = split[i + 1];
            if (one.equals(first) && two.equals(second)) {
                String three = split[i + 2];
                res.add(three);
            }
        }
        return res.toArray(new String[0]);
    }
}
// @lc code=end
