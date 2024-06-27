/*
 * @lc app=leetcode.cn id=2734 lang=java
 *
 * [2734] 执行子串操作后的字典序最小字符串
 */

// @lc code=start

class Solution2734 {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new Solution2734().smallestString(s));
    }

    public String smallestString(String s) {
        int indexOfFirstNonA = findFirstNonA(s);
        if (indexOfFirstNonA == s.length()) {
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(s.length() - 1, 'z');
            return sb.toString();
        }
        int indexOfFirstA_AfterFirstNonA = findFirstA_AfterFirstNonA(s, indexOfFirstNonA);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i >= indexOfFirstNonA && i < indexOfFirstA_AfterFirstNonA) {
                res.append((char) (c - 1));
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public int findFirstNonA(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'a') {
                return i;
            }
        }
        return s.length();
    }

    public int findFirstA_AfterFirstNonA(String s, int firstNonA) {
        for (int i = firstNonA; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                return i;
            }
        }
        return s.length();
    }
}
// @lc code=end
