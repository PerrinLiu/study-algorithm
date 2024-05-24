package study.leetcode.GFirst;
/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start

import java.util.Arrays;

class Solution72 {
    public static void main(String[] args) {
        System.out.println(new Solution72().minDistance1("hasse", "ssss"));
        System.out.println(new Solution72().minDistance("hasse", "ssss"));
    }

    private int[][] dp;
    private char[] m, n;

    public int minDistance(String word1, String word2) {
        m = word1.toCharArray();
        n = word2.toCharArray();
        int mLen = m.length, nLen = n.length;
        dp = new int[mLen + 1][nLen + 1];
        for (int i = 0; i <= mLen; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= nLen; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= mLen; i++) {
            for (int j = 1; j <= nLen; j++) {
                if (m[i - 1] == n[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int a = dp[i - 1][j - 1];
                    int b = dp[i][j - 1];
                    int c = dp[i - 1][j];
                    dp[i][j] = Math.min(a, Math.min(b, c)) + 1;
                }
            }
        }

        return dp[mLen][nLen];
    }

    private char[] s, t;
    private int[][] memo;

    public int minDistance1(String text1, String text2) {
        s = text1.toCharArray();
        t = text2.toCharArray();
        int n = s.length, m = t.length;
        memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1); // -1 表示还没有计算过
        }

        return dfs(n - 1, m - 1);
    }

    private int dfs(int i, int j) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        if (memo[i][j] != -1)
            return memo[i][j]; // 之前算过了
        if (s[i] == t[j])
            return memo[i][j] = dfs(i - 1, j - 1);
        return memo[i][j] = Math.min(Math.min(dfs(i - 1, j), dfs(i, j - 1)), dfs(i - 1, j - 1)) + 1;
    }
}
// @lc code=end
