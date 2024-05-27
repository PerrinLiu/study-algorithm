package study.leetcode.BFirst;
/*
 * @lc app=leetcode.cn id=2028 lang=java
 *
 * [2028] 找出缺失的观测数据
 */

// @lc code=start

import java.util.Arrays;

class Solution2028 {
    public static void main(String[] args) {
        // int[] arr = { 1, 5, 6 };
        int[] arr = { 3, 2, 4, 3 };
        int m = 4;
        int n = 2;
        System.out.println(Arrays.toString(new Solution2028().missingRolls(arr, m, n)));
    }

    // 1.将未知数组的长度（n）与已知数组的长度相加得到总长度（sumLen）
    // 2.计算数组的总值（sum） ：总长度*平均值 = 总值
    // 3.计算未知数组的总值（sumRes） ：总值 - 已知数组的和 = 未知数组的和
    // 4.根据骰子的值只有1到6，所以可以得出，如果 sumRes < n 或 sumRes > n *6
    // 则代表不可能存在符合要求的投掷数据
    // 5.循环：当sumRes>n时，代表骰子的结果（tag）可以继续+1，sumRes = sumRes-n；
    // 6.遍历n，给数组赋值，并且sumRes大于0时，表示sumRes个骰子需要+1，才能达到最终结果
    public int[] missingRolls(int[] rolls, int mean, int n) {
        // 总长度
        int sumLen = rolls.length + n;
        // 总值
        int sum = mean * sumLen;
        // 已知的数组总和
        int sumRoll = 0;
        for (int i = 0; i < rolls.length; i++) {
            sumRoll += rolls[i];
        }
        // 未知数组总和
        int sumRes = sum - sumRoll;
        // 不符合直接返回空数组
        if (sumRes < n || sumRes > n * 6) {
            return new int[0];
        }
        // 将每次投掷结果+1
        int tag = 0;
        while (sumRes > n) {
            sumRes -= n;
            tag++;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = tag;
            // 总值>0，则代表还需要将sumRes个骰子+1；
            if (sumRes-- > 0) {
                res[i] = res[i] + 1;
            }
        }
        return res;
    }
}
// @lc code=end
