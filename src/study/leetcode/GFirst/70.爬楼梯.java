package study.leetcode.GFirst;
/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start

import java.util.HashMap;

class Solution70 {
    // f(1) = 1; f(2) = 2;
    // f(3) = f(2) + f(1);
    // f(n) = f(n-1) + f(n-2);
    public static void main(String[] args) {
        System.out.println(new Solution70().climbStairs(5));
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (map.get(n) != null) {
            return map.get(n);
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        map.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        return map.get(n);
    }
}
// @lc code=end
