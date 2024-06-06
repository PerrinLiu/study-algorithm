package study.leetcode.BFirst;
/*
 * @lc app=leetcode.cn id=2938 lang=java
 *
 * [2938] 区分黑球与白球
 */

// @lc code=start
class Solution2938 {
    public static void main(String[] args) {
        System.out.println(new Solution2938().minimumSteps("10010"));
    }

    public long minimumSteps(String s) {
        long res = 0;
        int zeroSum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                res = res + (i - zeroSum);
                zeroSum++;
            }
        }
        return res;
    }

    public long minimumSteps1(String s) {
        char[] charArray = s.toCharArray();
        long res = 0;
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == '0' && charArray[i - 1] != '0') {
                while (i > 0 && charArray[i - 1] != '0') {
                    char temp = charArray[i];
                    charArray[i] = charArray[i - 1];
                    charArray[i - 1] = temp;
                    res++;
                    i--;
                }
            }
        }
        return res;
    }
}
// @lc code=end
