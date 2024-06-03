/*
 * @lc app=leetcode.cn id=740 lang=java
 *
 * [740] 删除并获得点数
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public static void main(String[] args) {
        // int[] nums = { 8, 7, 3, 8, 1, 4, 10, 10, 10, 2 };
        int[] nums = { 1, 2, 3, 4 };
        // int[] nums = { 4, 10, 10, 8, 1, 4, 10, 9, 7, 6 };
        System.out.println(new Solution().deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
// @lc code=end
