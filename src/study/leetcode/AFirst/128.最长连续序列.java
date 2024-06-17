/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Solution128 {
    public static void main(String[] args) {
        // int[] nums = { 0 };
        // int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        int[] nums = { 0, 1, 2, 1 };
        System.out.println(new Solution128().longestConsecutive(nums));
        int[] nums2 = { 100, 4, 200, 1, 3, 2 };
        System.out.println(new Solution128().longestConsecutive(nums2));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int result = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int newLength = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    newLength++;
                }
                result = Math.max(result, newLength);
            }
        }
        return result;
    }

    public int longestConsecutive3(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int result = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int newLength = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    newLength++;
                }
                result = Math.max(result, newLength);
            }
        }
        return result;
    }

    public int longestConsecutive2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int i = 0;
        while (i < nums.length) {
            int temp = 1;
            while (i < nums.length - 1 && (nums[i] == nums[i + 1] - 1 || nums[i] == nums[i + 1])) {
                if (nums[i] == nums[i + 1] - 1) {
                    temp++;
                }
                i++;
            }
            i++;
            res = Math.max(res, temp);
        }
        return res;
    }

    public int longestConsecutive1(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }
        int res = 0;
        List<Integer> list = new ArrayList<>(treeSet);
        for (int i = 0; i < list.size(); i++) {
            int temp = 1;
            while (i < list.size() - 1 && list.get(i) == list.get(i + 1) - 1) {
                temp++;
                i++;
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}
// @lc code=end
