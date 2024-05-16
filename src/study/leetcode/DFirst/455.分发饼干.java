package study.leetcode.DFirst;
/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start

import java.util.Arrays;

class Solution455 {
    public static void main(String[] args) {
        // int[] g = { 10, 9, 8, 7 };
        // int[] s = { 5, 6, 7, 8 };
        int[] g = { 1, 2, 3 };
        int[] s = { 1, 1 };
        int contentChildren = new Solution455().findContentChildren(g, s);
        System.out.println(contentChildren);
    }

    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int n = 0, m = 0;
        while (n < g.length && m < s.length) {
            if (g[n] <= s[m]) {
                res++;
                m++;
                n++;
            } else {
                m++;
            }
        }
        return res;
    }
}
// @lc code=end
