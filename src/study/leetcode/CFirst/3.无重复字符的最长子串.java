package study.leetcode.CFirst;
/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution3 {
    public static void main(String[] args) {

        System.out.println(new Solution3().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = 1;
            Set<Character> list = new HashSet<>();
            list.add(s.charAt(i));
            int left = i + 1;
            while (left < s.length() && !list.contains(s.charAt(left))) {
                list.add(s.charAt(left++));
                temp++;
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}
// @lc code=end
