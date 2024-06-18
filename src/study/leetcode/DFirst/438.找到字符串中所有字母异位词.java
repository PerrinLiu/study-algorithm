package study.leetcode.DFirst;
/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution438 {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println("\n" + new Solution438().findAnagrams(s, p));
    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        char[] arr = p.toCharArray();
        Arrays.sort(arr);
        String valueOf = String.valueOf(arr);
        for (int i = 0; i <= sLen - pLen; i++) {
            char[] temp = s.substring(i, i + pLen).toCharArray();
            Arrays.sort(temp);
            if (valueOf.equals(String.valueOf(temp))) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        char[] arr = p.toCharArray();
        Arrays.sort(arr);
        String valueOf = String.valueOf(arr);
        for (int i = 0; i <= sLen - pLen; i++) {
            char[] temp = s.substring(i, i + pLen).toCharArray();
            Arrays.sort(temp);
            if (valueOf.equals(String.valueOf(temp))) {
                res.add(i);
                char c = s.charAt(res.get(res.size() - 1));
                while (i + pLen < s.length() && c == s.charAt(i + pLen)) {
                    c = s.charAt(res.get(res.size() - 1));
                    res.add(i++);
                }

            }
        }
        return res;
    }
}
// @lc code=end
