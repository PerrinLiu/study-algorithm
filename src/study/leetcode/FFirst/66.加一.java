package study.leetcode.FFirst;
/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start

import java.util.Arrays;

class Solution66 {
    public static void main(String[] args) {
        // int[] arr = { 8, 9, 9, 9 };
        int[] arr = { 9 };
        System.out.println(Arrays.toString(new Solution66().plusOne(arr)));

    }

    public int[] plusOne(int[] digits) {
        int len = digits.length - 1;
        while (len >= 0 && digits[len] == 9) {
            digits[len] = 0;
            len--;
        }
        if (len < 0) {
            int[] arr = new int[digits.length + 1];
            System.arraycopy(digits, 0, arr, 0, digits.length);
            arr[0] = 1;
            return arr;
        }
        digits[len] = digits[len] + 1;
        return digits;
    }
}
// @lc code=end
