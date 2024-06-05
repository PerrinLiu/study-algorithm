/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3 的幂
 */

// @lc code=start
class Solution {

    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree1(int n) {
        int number = 0;
        while (number < 32) {
            if (n == Math.pow(3, number++)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
