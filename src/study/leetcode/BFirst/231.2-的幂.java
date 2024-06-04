/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2 的幂
 */

// @lc code=start
class Solution231 {
    public static void main(String[] args) {
        System.out.println(new Solution231().isPowerOfTwo(16));
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo1(int n) {
        int number = 0;
        while (number < 32) {
            if (n == Math.pow(2, number++)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
