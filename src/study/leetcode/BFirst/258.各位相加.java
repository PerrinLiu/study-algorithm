/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 */

// @lc code=start
class Solution258 {
    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num = num / 10;
            }
            num = sum;
        }

        return num;
    }

    public int addDigits1(int num) {
        if (num < 10) {
            return num;
        }
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num = num / 10;
        }
        return addDigits(res);
    }
}
// @lc code=end
