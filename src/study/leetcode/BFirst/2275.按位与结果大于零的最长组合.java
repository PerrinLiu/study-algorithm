/*
 * @lc app=leetcode.cn id=2275 lang=java
 *
 * [2275] 按位与结果大于零的最长组合
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] candidates = { 10, 72, 58, 33, 36, 70, 12, 88, 9, 48, 78, 97, 87, 19, 78, 9, 47, 73 };
        System.out.println(new Solution().largestCombination(candidates));
    }

    public int largestCombination1(int[] candidates) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            int num = 1;
            for (int j = i + 1; j < candidates.length; j++) {
                if (candidates.length - j < res) {
                    return res;
                }
                if (!list.contains(candidates[j]) && (candidates[i] & candidates[j]) > 0) {
                    list.add(candidates[j]);
                    num++;
                }
            }
            res = Math.max(num, res);
            list.clear();
        }
        return res;
    }

    // 题解
    // 我们先假设 candidates[i]为 8 位无符号数（即 0-255 的正整数），那么请问：
    // 如下几个二进制数相与，最多有几个数相与结果不为 0？

    // 编号 数值
    // 0 1111 1111
    // 1 0000 0010
    // 2 0000 0011
    // 3 1000 0000
    // 4 0100 0000
    // 编号 0、1、2 相与，最多有 3 个数相与结果不为 0。
    // 编号 0、3、4 相与，最多有 2 个数相与结果不为 0。
    // 编号 0-4 相与，最多有 3 个数相与结果不为 0。

    // 我们发现如果某几个数某一位都有 1，那么这几个数相与，结果必定不为 0（即一定大于 0）。
    // 我们还发现，如果设这几个数每一位 1 的个数为 cnt，不论几个数相与，那么一定有「最多有 max(cnt) 个结果不为 0」。

    // 所以我们简单计算每一位分别有多少个 1，并选择他们的最大值即可得到答案。

    public int largestCombination(int[] candidates) {
        int max = Integer.MIN_VALUE;

        // 设 i 为需要统计的位数，最高需要统计 24 位。
        //
        // 因为 candidates[i] 最大值为 10^7；
        // 10^7 可以拆解为 10^6 * 10；
        // 2^10 是 1024，两个 2^10 大约就是 10^6 （1024 x 1024）;
        // 2^4 = 16 远远大于 10。
        // 所以 2^24 远远大于 10^7。
        for (int i = 0; i < 24; i++) {
            // 使用 cnt 统计某一位 1 的个数
            int cnt = 0;
            for (int cand : candidates) {
                // 1 << i 用于表示哪一位为 1，首先统计从右数第一位为 1 的个数。
                // 由于 1 << i 只有一位为 1，其余位都为 0，
                // 所以 cand & 1 << i 如果等于 0，则表示当前位为 0，否则 cnt 加 1。
                max = Math.max(max, cnt += (cand & 1 << i) == 0 ? 0 : 1);
            }
        }
        return max;
    }
}
// @lc code=end
