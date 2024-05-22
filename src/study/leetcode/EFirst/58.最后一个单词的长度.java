package study.leetcode.EFirst;
/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution58 {
    public static void main(String[] args) {
        System.out.println(new Solution58().lengthOfLastWord("a "));
    }

    public int lengthOfLastWord(String s) {
        int len = s.length() - 1;
        int res = 0;
        while (len >= 0 && s.charAt(len) == ' ') {
            len--;
        }
        while (len >= 0 && s.charAt(len) != ' ') {
            len--;
            res++;
        }
        return res;
    }
}
// @lc code=end
