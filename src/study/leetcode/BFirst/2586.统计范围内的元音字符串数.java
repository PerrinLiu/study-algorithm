package study.leetcode.BFirst;
/*
 * @lc app=leetcode.cn id=2586 lang=java
 *
 * [2586] 统计范围内的元音字符串数
 */

// @lc code=start
class Solution2586 {
    public static void main(String[] args) {
        String[] words = { "are", "amy", "u" };
        System.out.println(new Solution2586().vowelStrings(words, 0, 2));
    }

    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        String aeiou = "aeiou";
        while (left <= right) {
            String first = String.valueOf(words[left].charAt(0));
            String last = String.valueOf(words[left].charAt(words[left].length() - 1));
            if (aeiou.contains(first) && aeiou.contains(last)) {
                res++;
            }
            left++;
        }
        return res;
    }

    public int vowelStrings1(String[] words, int left, int right) {
        int res = 0;
        String aeiou = "aeiou";
        while (left <= right) {
            String first = words[left].substring(0, 1);
            String last = words[left].substring(words[left].length() - 1);
            if (aeiou.contains(first) && aeiou.contains(last)) {
                res++;
            }
            left++;
        }
        return res;
    }
}
// @lc code=end
