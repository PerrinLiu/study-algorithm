/*
 * @lc app=leetcode.cn id=2813 lang=java
 *
 * [2813] 子序列最大优雅度
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        int[][] items = { { 10, 4 }, { 2, 2 }, { 3, 3 }, { 10, 4 } };
        int k = 3;
        System.out.println(new Solution().findMaximumElegance(items, k));
    }

    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (item0, item1) -> item1[0] - item0[0]);
        // 记录类别的数量
        HashSet<Integer> categorySet = new HashSet<Integer>();
        long profit = 0, res = 0;
        // 记录上一次的利润（队列
        ArrayDeque<Integer> st = new ArrayDeque<Integer>();
        for (int i = 0; i < items.length; i++) {
            // 当子序列长度小于k时，
            if (i < k) {
                // 利润相加
                profit += items[i][0];
                // 加入类别集合（存在相同类别时则记录本次的利润到队列
                if (!categorySet.add(items[i][1])) {
                    st.push(items[i][0]);
                }
                // 当子序列的长度足够时，则判断利润集合是否不为空且类别是否不同
                // 因为数组已经排序过，如果类别相同的话，肯定是之前的利润更大，无需替换
            } else if (!st.isEmpty() && categorySet.add(items[i][1])) {
                // 将本次的利润与上一个类别相同的利润替换，同时从队列出队
                profit += items[i][0] - st.pop();
            }
            res = Math.max(res, profit + (long) categorySet.size() * categorySet.size());
        }
        return res;
    }
}
// @lc code=end
