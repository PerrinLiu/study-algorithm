/*
 * @lc app=leetcode.cn id=1137 lang=java
 *
 * [1137] 第 N 个泰波那契数
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().tribonacci(25));
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    public int tribonacci(int n) {
        if (map.get(n) != null) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        map.put(n, tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1));
        return map.get(n);
    }
}
// @lc code=end
