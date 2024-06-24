package study.leetcode.EFirst;
/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Solution503 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        System.out.println(Arrays.toString(new Solution503().nextGreaterElements(nums)));
    }

    public int[] nextGreaterElements(int[] nums) {
        // 创建结果数组
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        if (n == 1)
            return res;
        // 使用单调栈，栈中保存索引
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n * 2 - 1; ++i) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        // 返回结果
        return res;
    }

    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        // 遍历两遍数组
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }
}
// @lc code=end
