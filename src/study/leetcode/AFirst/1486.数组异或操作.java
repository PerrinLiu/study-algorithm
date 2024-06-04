/*
 * @lc app=leetcode.cn id=1486 lang=java
 *
 * [1486] 数组异或操作
 */

// @lc code=start
class Solution1486 {
    public static void main(String[] args) {
        System.out.println(new Solution1486().xorOperation(4, 3));
    }

    public int xorOperation(int n, int start) {
        if (n == 1) {
            return start;
        }
        int res = start;
        while (n != 1) {
            start += 2;
            res = res ^ start;
            n--;
        }
        return res;
    }
}
// @lc code=end
