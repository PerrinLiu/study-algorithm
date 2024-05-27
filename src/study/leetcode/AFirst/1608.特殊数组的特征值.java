package study.leetcode.AFirst;
/*
 * @lc app=leetcode.cn id=1608 lang=java
 *
 * [1608] 特殊数组的特征值
 */

// @lc code=start

import java.util.Arrays;

class Solution1608 {
    public static void main(String[] args) {
        // int[] nums = { 3, 6, 7, 7, 0 };
        int[] nums = { 0, 4, 3, 0, 4 };
        System.out.println(new Solution1608().specialArray(nums));
    }

    // public int specialArray(int[] nums) {
    // int len = nums.length;
    // int index = 1;
    // while (len > 0) {
    // int i = 0;
    // for (int nums2 : nums) {
    // if (index == 0) {
    // break;
    // }
    // if (len <= nums2) {
    // i++;
    // } else {
    // index--;
    // }
    // }
    // if (i == len) {
    // return len;
    // }
    // len--;
    // index = nums.length - len + 1;
    // }
    // return -1;
    // }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int res = nums.length;
        int index = 0;
        while (res > 0) {
            if (nums[index++] >= res) {
                if (index != 1) {
                    res = nums[index - 2] == res ? -1 : res;
                }
                return res;
            }
            res--;
        }
        return -1;
    }
}
// @lc code=end
