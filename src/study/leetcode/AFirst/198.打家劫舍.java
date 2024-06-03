package study.leetcode.AFirst;
/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution198 {
    public static void main(String[] args) {
        // int[] nums = { 1, 2, 3, 1 };
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(new Solution198().rob(nums));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    public int rob1(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                a += nums[i];
            } else {
                b += nums[i];
            }
        }
        return Math.max(a, b);
    }
}
// @lc code=end
