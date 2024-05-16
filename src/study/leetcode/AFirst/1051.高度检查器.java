/*
 * @lc app=leetcode.cn id=1051 lang=java
 *
 * [1051] 高度检查器
 */

// @lc code=start

import java.util.Arrays;

class Solution1051 {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 1 };
        System.out.println(new Solution1051().heightChecker(arr));
    }

    public int heightChecker1(int[] heights) {
        int[] copy = new int[heights.length];
        System.arraycopy(heights, 0, copy, 0, copy.length);
        Arrays.sort(heights);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (copy[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }

    public int heightChecker(int[] heights) {
        int m = Arrays.stream(heights).max().getAsInt();
        int[] cnt = new int[m + 1];
        for (int h : heights) {
            ++cnt[h];
        }

        int idx = 0, ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= cnt[i]; ++j) {
                if (heights[idx] != i) {
                    ++ans;
                }
                ++idx;
            }
        }
        return ans;
    }
}
// @lc code=end
