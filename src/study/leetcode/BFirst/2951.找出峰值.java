/*
 * @lc app=leetcode.cn id=2951 lang=java
 *
 * [2951] 找出峰值
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution2951 {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 3, 8, 5 };
        System.out.println(new Solution2951().findPeaks(arr));
    }

    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            int left = mountain[i - 1];
            int right = mountain[i + 1];
            if (mountain[i] > left && mountain[i] > right) {
                list.add(i);
            }
        }
        return list;
    }
}
// @lc code=end
