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
        String s = "ababc";
        String p = "abc";
        System.out.println("\n" + new Solution438().findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
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

    public List<Integer> findAnagrams2(String s, String p) {
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
