/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        // String str = "azxxzy";
        // String str = "abbaca";
        String str = "aaaaaaaa";
        System.out.println(new Solution().removeDuplicates(str));
    }

    public String removeDuplicates(String s) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }

    public String removeDuplicates1(String s) {
        int length = s.length();
        int left = 0;
        int right = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length - 1; i++) {
            left = i;
            right = i + 1;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (left != i) {
                break;
            }
        }
        if (right - left != 1) {
            sb.append(s.substring(0, left + 1));
            sb.append(s.substring(right, length));
            s = removeDuplicates(sb.toString());
        }
        return s;
    }
}
// @lc code=end
