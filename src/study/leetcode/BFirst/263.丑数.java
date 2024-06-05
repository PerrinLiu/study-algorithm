/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
class Solution263 {
    public static void main(String[] args) {
        System.out.println(new Solution263().isUgly(-2147483648));
    }

    public boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }

        // 依次除以2、3和5
        int[] factors = { 2, 3, 5 };
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
// @lc code=end
