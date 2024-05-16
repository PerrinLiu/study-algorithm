/*
 * @lc app=leetcode.cn id=1953 lang=java
 *
 * [1953] 你可以工作的最大周数
 */

// @lc code=start
class Solution1953 {
    public static void main(String[] args) {
        int[] milestones = { 5, 2, 1 };
        Solution1953 solution = new Solution1953();
        System.out.println(solution.numberOfWeeks(milestones));
    }

    public long numberOfWeeks(int[] milestones) {
        long s = 0;
        int m = 0;
        for (int x : milestones) {
            s += x;
            m = Math.max(m, x);
        }
        return m > s - m + 1 ? (s - m) * 2 + 1 : s;
    }
}
// @lc code=end
