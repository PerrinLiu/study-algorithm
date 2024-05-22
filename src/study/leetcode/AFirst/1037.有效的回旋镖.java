package study.leetcode.AFirst;/*
 * @lc app=leetcode.cn id=1037 lang=java
 *
 * [1037] 有效的回旋镖
 */

// @lc code=start
class Solution1037 {
    public static void main(String[] args) {
        // 3
        // 2
        // 1
        // int[][] arr = { { 1, 1 }, { 2, 3 }, { 3, 2 } };
        int[][] arr = { { 1, 1 }, { 2, 2 }, { 3, 3 } };

        boolean boomerang = new Solution1037().isBoomerang(arr);
        System.out.println(boomerang);

    }

    public boolean isBoomerang(int[][] points) {
        // 2,1,2,1
        int[] v1 = { points[1][0] - points[0][0], points[1][1] - points[0][1] };// 1,1
        // 3,1,3,1
        int[] v2 = { points[2][0] - points[0][0], points[2][1] - points[0][1] };// 2,2
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }
}
// @lc code=end
