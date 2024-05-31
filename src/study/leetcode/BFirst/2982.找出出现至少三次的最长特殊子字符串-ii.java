/*
 * @lc app=leetcode.cn id=2982 lang=java
 *
 * [2982] 找出出现至少三次的最长特殊子字符串 II
 */

// @lc code=start

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

class Solution2982 {
    public static void main(String[] args) {
        System.out.println(new Solution2982().maximumLength("aabbcccc"));
    }

    public int maximumLength(String s) {
        int n = s.length();
        Map<Character, List<Integer>> cnt = new HashMap<>();

        for (int i = 0, j = 0; i < n; i = j) {
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            cnt.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(j - i);
        }

        int res = -1;
        for (List<Integer> vec : cnt.values()) {
            int lo = 1, hi = n - 2;
            while (lo <= hi) {
                int mid = (lo + hi) >> 1;
                int count = 0;
                for (int x : vec) {
                    if (x >= mid) {
                        count += x - mid + 1;
                    }
                }
                if (count >= 3) {
                    res = Math.max(res, mid);
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return res;
    }

    public int maximumLength2(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        char[] charArray = s.toCharArray();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int number = 1;
            while (i + 1 < length && charArray[i] == charArray[i + 1]) {
                i++;
                number++;
            }
            if (number > map.getOrDefault(charArray[i], 0)) {
                map.put(charArray[i], number);
            }
        }
        List<Entry<Character, Integer>> list = new ArrayList<Entry<Character, Integer>>(map.entrySet());
        Collections.sort(list, (entry1, entry2) -> {
            return entry2.getValue() - entry1.getValue();
        });

        int res = -1;
        for (Entry<Character, Integer> entrySet : list) {
            if (entrySet.getValue() < res) {
                break;
            }
            String str = "";
            for (int i = 0; i < entrySet.getValue(); i++) {
                str += entrySet.getKey();
            }

            int num = 1;
            while (str.length() > 0) {
                int number = 0;
                int index = 0;
                if (num == 2) {
                    res = Math.max(res, str.length() - 2);
                }
                while (s.indexOf(str, index) != -1) {
                    index = s.indexOf(str, index) + 1;
                    if (++number == 3) {
                        break;
                    }
                }
                if (number == 3) {
                    res = Math.max(res, str.length());
                    break;
                }
                str = str.substring(0, str.length() - 1);
                num++;
            }
        }
        return res;
    }

    public int maximumLength1(String s) {
        int res = -1;
        char[] charArray = s.toCharArray();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int index = i;
            StringBuilder str = new StringBuilder().append(charArray[i]);
            while (i + 1 < length && charArray[i] == charArray[i + 1]) {
                str.append(charArray[i + 1]);
                i++;
            }
            String temp = str.toString();
            while (temp.length() > res && temp.length() != 0) {
                int number = index;
                int k = 1;
                while (s.indexOf(temp, number + 1) != -1) {
                    k++;
                    number = s.indexOf(temp, number + 1);
                }
                if (k >= 3) {
                    res = Math.max(temp.length(), res);
                    break;
                }
                temp = temp.substring(0, temp.length() - 1);

            }
        }
        return res;
    }
}
// @lc code=end
