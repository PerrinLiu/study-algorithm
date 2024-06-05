/*
 * @lc app=leetcode.cn id=3072 lang=java
 *
 * [3072] 将元素分配到两个数组中 II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] nums = { 5, 14, 3, 1, 2 };
        System.out.println(new Solution().resultArray(nums));
    }

    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for (int i = 2; i < n; i++) {
            int[] cnt1 = greaterCount(arr1, nums[i]);
            int[] cnt2 = greaterCount(arr2, nums[i]);
            if (cnt1[0] > cnt2[0]) {
                arr1.add(cnt1[1], nums[i]);
            } else if (cnt1[0] == cnt2[0]) {
                if (arr1.size() <= arr2.size()) {
                    arr1.add(cnt1[1], nums[i]);
                } else {
                    arr2.add(cnt2[1], nums[i]);
                }
            } else {
                arr2.add(cnt2[1], nums[i]);
            }
        }
        arr1.addAll(arr2);
        return arr1.stream().mapToInt(Integer::intValue).toArray();
    }

    private int[] greaterCount(List<Integer> arr, int val) {
        int l = 0, r = arr.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr.get(m) > val) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return new int[] { arr.size() - r, r + 1 };
    }
}
// @lc code=end
