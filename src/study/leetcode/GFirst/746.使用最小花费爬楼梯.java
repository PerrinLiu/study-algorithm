package study.leetcode.GFirst;
/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution746 {
    public static void main(String[] args) {
        // int[] cost = { 10, 15, 20 };
        int[] cost = { 1, 100, 1, 1, 100, 1 };
        System.out.println(new Solution746().minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int a = dp[i - 1] + cost[i - 1];
            int b = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(a, b);
        }
        return dp[n];
    }
}
// @lc code=end
