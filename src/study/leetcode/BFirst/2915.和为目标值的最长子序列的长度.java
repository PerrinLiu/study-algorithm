/*
 * @lc app=leetcode.cn id=2915 lang=java
 *
 * [2915] 和为目标值的最长子序列的长度
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution2915 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 3, 5, 2, 3, 4);
        new Solution2915().lengthOfLongestSubsequence1(list, 12);
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                if (dp[i - num] != -1) {
                    dp[i] = Math.max(dp[i], dp[i - num] + 1);
                }
            }
        }
        return dp[target];
    }

    public int lengthOfLongestSubsequence1(List<Integer> nums, int target) {

        Collections.sort(nums);
        for (int num : nums) {
            int res = 1;
            int number = num;
            while (res < nums.size() && number < target) {
                number += nums.get(res++);
            }
            if (number == target) {
                return res;
            }
        }
        return -1;

    }
}
// @lc code=end
