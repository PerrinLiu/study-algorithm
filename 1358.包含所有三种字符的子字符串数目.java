/*
 * @lc app=leetcode.cn id=1358 lang=java
 *
 * [1358] 包含所有三种字符的子字符串数目
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSubstrings("abcabc"));
    }

    public int numberOfSubstrings(String s) {
        int length = s.length();
        String temp = "";
        int res = 0;
        for (int i = 0; i < length - 3; i++) {
            temp = s.substring(i, i + 3);
            if (temp.contains("a") && temp.contains("b") && temp.contains("c")) {
                res += length - i - 2;
                temp = "";
            }
        }
        return res;

    }
}
// @lc code=end
