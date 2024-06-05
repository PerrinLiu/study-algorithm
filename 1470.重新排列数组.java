/*
 * @lc app=leetcode.cn id=1470 lang=java
 *
 * [1470] 重新排列数组
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] arrs = { 2, 5, 1, 3, 4, 7 };
        System.out.println(Arrays.toString(new Solution().shuffle(arrs, 3)));
    }

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int temp = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            res[i] = nums[temp++];
            res[i + 1] = nums[n++];
        }
        return res;
    }

    public int[] shuffle2(int[] nums, int n) {
        int[] res = new int[2 * n];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            res[i] = i % 2 == 1 ? nums[n++] : nums[temp++];
        }
        return res;
    }

    public int[] shuffle1(int[] nums, int n) {
        int[] res = new int[2 * n];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                res[i] = nums[n++];
            } else {
                res[i] = nums[temp++];
            }
        }
        return res;
    }
}
// @lc code=end
