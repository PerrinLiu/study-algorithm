/*
 * @lc app=leetcode.cn id=2786 lang=java
 *
 * [2786] 访问数组中的位置使分数最大
 */

// @lc code=start
class Solution2786 {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 6, 1, 9, 2 };
        int x = 5;
        System.out.println(new Solution2786().maxScore(nums, x));
    }

    public long maxScore(int[] nums, int x) {
        long res = nums[0];
        long[] dp = { Integer.MIN_VALUE, Integer.MIN_VALUE };
        dp[nums[0] % 2] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int parity = (int) (nums[i] % 2);
            long cur = Math.max(dp[parity] + nums[i], dp[1 - parity] - x + nums[i]);
            res = Math.max(res, cur);
            dp[parity] = Math.max(dp[parity], cur);
        }
        return res;
    }
}
// @lc code=end
