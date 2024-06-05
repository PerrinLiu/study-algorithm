package study.leetcode.HFirst;
/*
 * @lc app=leetcode.cn id=852 lang=java
 *
 * [852] 山脉数组的峰顶索引
 */

// @lc code=start

import java.util.Arrays;

class Solution852 {
    public static void main(String[] args) {
        // int[] arr = { 0, 1, 0 };
        int[] arr = { 24, 69, 100, 99, 79, 78, 67, 36, 26, 19 };
        System.out.println(new Solution852().peakIndexInMountainArray(arr));
    }

    public int peakIndexInMountainArray(int[] arr) {
        int index = 0;
        int left = 1;
        int right = arr.length - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid] > arr[mid + 1]) {
                index = mid;
                right = mid - 1;
            }
        }
        return index;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
        while (left < right && arr[left] < arr[left + 1]) {
            left++;
        }
        return left;
    }

    public int peakIndexInMountainArray1(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
        int res = 1;
        while (left < right) {
            if (arr[left] > arr[right]) {
                res = left;
                right--;
            } else {
                res = right;
                left++;
            }
        }
        return res;
    }
}
// @lc code=end
