/*
 * @lc app=leetcode.cn id=1358 lang=java
 *
 * [1358] 包含所有三种字符的子字符串数目
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSubstrings1("abcabc"));
    }

    public int numberOfSubstrings1(String s) {
        int length = s.length();
        String temp = "";
        int res = 0;
        for (int i = 0; i < length - 2; i++) {
            int index = 3;
            temp = s.substring(i, i + index);
            while (i + index < length && !(temp.contains("a") && temp.contains("b") && temp.contains("c"))) {
                index++;
                temp = s.substring(i, i + index);
            }
            if (temp.contains("a") && temp.contains("b") && temp.contains("c")) {
                res += length - i - index + 1;
            }
        }
        return res;

    }

    public int numberOfSubstrings(String s) {
        char[] c = s.toCharArray(); // 将字符串转化为字符数组
        int[] count = new int['d']; // 计数数组，只关心'a','b','c'的出现次数
        int left = 0, ans = 0; // left为滑动窗口的左边界，ans为答案

        // right为滑动窗口的右边界
        for (int right = 0; right < c.length; right++) {
            count[c[right]]++; // 将右边界的字符纳入计数

            // 当窗口包含所有'a','b','c'时，尝试缩小窗口大小
            while (count['a'] > 0 && count['b'] > 0 && count['c'] > 0) {
                count[c[left++]]--; // 移动窗口左边界，减少该字符的计数
            }

            // 所有从0到left-1开始，到right结束的子串都是有效的
            ans += left;
        }
        return ans; // 返回有效子串的数量
    }
}
// @lc code=end
