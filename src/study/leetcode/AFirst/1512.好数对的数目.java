/*
 * @lc app=leetcode.cn id=1512 lang=java
 *
 * [1512] 好数对的数目
 */

// @lc code=start

import java.util.HashMap;

class Solution1512 {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            Integer integer = map.getOrDefault(num, 0);
            res += integer;
            map.put(num, integer + 1);
        }
        return res;
    }
}
// @lc code=end
