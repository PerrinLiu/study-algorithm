package study.leetcode.CFirst;
/*
 * @lc app=leetcode.cn id=3142 lang=java
 *
 * [3142] 判断矩阵是否满足条件
 */

// @lc code=start
class Solution3142 {
    public static void main(String[] args) {
        int[][] grid = { { 1 }, { 2 }, { 3 } };
        System.out.println(new Solution3142().satisfiesConditions(grid));
    }

    public boolean satisfiesConditions(int[][] grid) {
        int len = grid.length;
        int arrLen = grid[0].length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < arrLen; j++) {
                if (i < len - 1 && grid[i][j] != grid[i + 1][j]) {
                    return false;
                }
                if (j < arrLen - 1 && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
