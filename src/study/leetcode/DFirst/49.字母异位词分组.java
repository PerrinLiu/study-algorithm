package study.leetcode.DFirst;
/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Solution49 {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(new Solution49().groupAnagrams(strs).toString());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String string = String.valueOf(charArray);
            map.putIfAbsent(string, new ArrayList<String>());
            map.get(string).add(s);
        }
        return map.values().stream().collect(Collectors.toList());
    }
}
// @lc code=end
