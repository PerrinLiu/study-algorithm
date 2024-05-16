package study.leetcode.IFirst;
/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution917 {
    public static void main(String[] args) {
        String s = "ab-cd";
        System.out.println(new Solution917().reverseOnlyLetters(s));
    }

    public String reverseOnlyLetters(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (left < right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (!Character.isLetter(c1)) {
                left++;
            } else if (!Character.isLetter(c2)) {
                right--;
            } else {
                swap(arr, left, right);
                right--;
                left++;
            }
        }
        return new String(arr);
    }

    public void swap(char[] c, int l, int r) {
        char temp = c[l];
        c[l] = c[r];
        c[r] = temp;
    }

    public String reverseOnlyLetters1(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                s = swap(s, left, right);
                right--;
                left++;
            } else if (Character.isLetter(c1)) {
                right--;
            } else {
                left++;
            }
        }
        return s;
    }

    public String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        char c1 = sb.charAt(i);
        char c2 = sb.charAt(j);
        sb.setCharAt(i, c2);
        sb.setCharAt(j, c1);
        return sb.toString();
    }
}
// @lc code=end
