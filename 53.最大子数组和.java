/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(new Solution().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (temp + nums[i] >= 0) {
                temp += nums[i];
                res = Math.max(temp, res);
            } else {
                temp = 0;
                res = Math.max(nums[i], res);
            }
        }
        return res;
    }
}
// @lc code=end
