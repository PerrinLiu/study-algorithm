package study.leetcode.CFirst;
/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution392 {
    public static void main(String[] args) {
        String s = "twn";
        String t = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxtxxxxxxxxxxxxxxxxxxxxwxxxxxxxxxxxxxxxxxxxxxxxxxn";
        boolean subsequence = new Solution392().isSubsequence1(s, t);
        System.out.println(subsequence);
    }

    public boolean isSubsequence(String s, String t) {
        boolean res = true;
        int l1 = s.length();
        for (int i = 0; i < l1; i++) {
            int indexOf = t.indexOf(s.charAt(i));
            t = t.substring(indexOf + 1);
            if (!(indexOf >= 0)) {
                res = false;
                break;
            }
        }
        return res;
    }

    public boolean isSubsequence1(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
// @lc code=end
