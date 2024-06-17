/*
 * @lc app=leetcode.cn id=2965 lang=java
 *
 * [2965] 找出缺失和重复的数字
 */

// @lc code=start

import java.util.Arrays;

class Solution2965 {
    public static void main(String[] args) {
        // int[][] grid = { { 9, 1, 7 }, { 8, 9, 2 }, { 3, 4, 6 } };
        // int[][] grid = { { 2, 2 }, { 3, 4 } };
        int[][] grid = { { 1, 3 }, { 2, 2 } };
        System.out.println(Arrays.toString(new Solution2965().findMissingAndRepeatedValues(grid)));
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] res = new int[2];
        int[] arr = new int[grid.length * grid.length];
        for (int[] grid2 : grid) {
            for (int grid22 : grid2) {
                arr[grid22 - 1] = arr[grid22 - 1] + 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                res[0] = i + 1;
            }
            if (arr[i] == 0) {
                res[1] = i + 1;
            }
        }
        return res;
    }
}
// @lc code=end
