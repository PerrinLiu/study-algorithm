/*
 * @lc app=leetcode.cn id=1422 lang=java
 *
 * [1422] 分割字符串的最大得分
 */

// @lc code=start
class Solution1422 {

    public static void main(String[] args) {
        System.out.println(new Solution1422().maxScore("011101"));
    }

    public int maxScore(String s) {
        int res = 0;
        int zeroSum = 0;
        int oneSum = s.length();
        for (int i = 0; i < s.length() - 1; i++) {
            char charAt = s.charAt(i);
            if (charAt == '0') {
                zeroSum++;
                oneSum--;
            }
            oneSum = oneSum - zeroSum;
            res = Math.max(res, oneSum + zeroSum);
        }
        return res;
    }

    public int maxScore1(String s) {
        int oneSum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                oneSum++;
            }
        }
        int res = 0;
        int zeroSum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char charAt = s.charAt(i);
            if (charAt == '0') {
                zeroSum++;
            } else {
                oneSum--;
            }
            res = Math.max(res, zeroSum + oneSum);
        }
        return res;
    }
}
// @lc code=end
