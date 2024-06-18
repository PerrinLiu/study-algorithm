/*
 * @lc app=leetcode.cn id=2288 lang=java
 *
 * [2288] 价格减免
 */

// @lc code=start

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution2288 {
    public static void main(String[] args) {
        // String sentence = "there are $1 $2 and 5$ candies in the shop";
        String sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$";
        int discount = 100;
        System.out.println();
        System.out.println(new Solution2288().discountPrices(sentence, discount));
    }

    public String discountPrices(String sentence, int discount) {
        double d = 1 - discount / 100.0;
        String[] a = sentence.split(" ");
        for (int i = 0; i < a.length; i++) {
            if (check(a[i])) {
                a[i] = String.format("$%.2f", Long.parseLong(a[i].substring(1)) * d);
            }
        }
        return String.join(" ", a);
    }

    private boolean check(String S) {
        if (S.length() == 1 || S.charAt(0) != '$') {
            return false;
        }
        char[] s = S.toCharArray();
        for (int i = 1; i < s.length; i++) {
            if (!Character.isDigit(s[i])) {
                return false;
            }
        }
        return true;
    }

    public String discountPrices2(String sentence, int discount) {
        String[] split = sentence.split(" ");
        String regex = "^\\$\\d+$";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            // 创建匹配器
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                double money = Double.parseDouble(str.substring(1, str.length()));
                money = money - ((money * discount) / 100);
                split[i] = "$" + String.format("%.2f", money);
            }
            if (i != 0) {
                res.append(" ");
            }
            res.append(split[i]);
        }
        return res.toString();
    }

    public String discountPrices1(String sentence, int discount) {
        String[] split = sentence.split(" ");
        String regex = "^\\$\\d+$";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            // 创建匹配器
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                double money = Double.parseDouble(str.substring(1, str.length()));
                money = money - ((money * discount) / 100);
                split[i] = "$" + String.format("%.2f", money);
            }
        }
        for (int i = 0; i < split.length; i++) {
            if (i != 0) {
                res.append(" ");
            }
            res.append(split[i]);
        }
        return res.toString();
    }
}
// @lc code=end
