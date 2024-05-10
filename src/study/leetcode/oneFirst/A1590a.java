package study.leetcode.oneFirst;
/*
 * @lc app=leetcode.cn id=1590 lang=java
 *
 * [1590] 使数组和能被 P 整除 中等
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// @lc code=start
public class A1590a {
    public static void main(String[] args) {
        int[] nums = { 26, 19, 11, 14, 18, 4, 7, 1, 30, 23, 19, 8, 10, 6, 26, 3 };
        int p = 26;
        Solution solution = new Solution();
        System.out.println(solution.minSubarray(nums, p));
    }
}

class Solution {
    public int minSubarray(int[] nums, int p) {
        int length = nums.length;
        int res = 0;
        long sum = 0;
        HashMap<Long, Integer> has = new HashMap<>();
        for (int i = 0; i < length; i++) {
            long num = nums[i];
            has.put(num, has.get(num) == null ? 1 : has.get(num) + 1);
            sum += nums[i];
        }
        if (sum < p) {
            return -1;
        }
        long d = sum % p;
        if (d == 0) {
            return res;
        }
        int count = 0;
        long target = d;
        List<Long> list = new ArrayList<>();
        while (d != 0 && count < length) {
            HashMap<Long, Integer> temp = new HashMap<>();
            temp.putAll(has);
            for (long i = target; i > 0; i--) {
                int num = temp.getOrDefault(i, 0);
                if (num == 0) {
                    continue;
                }
                if (list.contains(i)) {
                    continue;
                }
                list.add(i);
                temp.put(i, num--);
                target = (target - i);
                i = target + 1;
                res++;
                if (target == 0) {
                    return res;
                }
            }
            target = d;
            res = 0;
            count++;
        }
        return -1;
    }
}
// @lc code=end
