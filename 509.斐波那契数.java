/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().fib(9));
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public int fib1(int n) {
        if (map.get(n) != null) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        map.put(n, fib(n - 1) + fib(n - 2));
        return map.get(n);
    }
}
// @lc code=end
