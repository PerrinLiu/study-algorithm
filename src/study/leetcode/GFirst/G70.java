package study.leetcode.GFirst;
/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

import java.util.HashMap;

public class G70 {

    public static void main(String[] args) {
        G70Solution g70Solution = new G70Solution();
        System.out.println(g70Solution.climbStairs(100));
    }
}

// @lc code=start
class G70Solution {
    HashMap<Integer, Long> map = new HashMap<>();

    public long climbStairs(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n <= 0) {
            return 0;
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
