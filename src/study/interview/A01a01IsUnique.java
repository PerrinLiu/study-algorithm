package study.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * a01a01是唯一
 *
 * @author llpy
 * @date 2024/05/09
 */
public class A01a01IsUnique {
    // 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
    // 简单
    public static void main(String[] args) {
        String str = "pop";
        System.out.println(new SolutionA01a01().isUnique2(str));

        int num = 0b11110001;
        int i = num >> 1;
        int i1 = i & 1;
        System.out.println(i1);
    }

}
// 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
//
// 示例 1：
//
//
// 输入: s = "leetcode"
// 输出: false
//
//
// 示例 2：
//
//
// 输入: s = "abc"
// 输出: true
//
//
// 限制：
//
//
// 0 <= len(s) <= 100
// s[i]仅包含小写字母
// 如果你不使用额外的数据结构，会很加分。
//
//
// Related Topics 位运算 哈希表 字符串 排序 👍 327 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
class SolutionA01a01 {
    public boolean isUnique(String astr) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < astr.length(); i++) {
            if (list.contains(astr.charAt(i))) {
                return false;
            }
            list.add(astr.charAt(i));
        }
        return true;
    }

    boolean isUnique2(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = c - 'a'; // 取得c的索引，a 对应 0，b 对应 1，z 对应 25
            int i1 = 1 << index;
            if ((num & i1) != 0) { // 不等于 0，表示某个字母已出现过
                // 注意：不能写成 (num & (1 << index)) == 1，因为存在 0000 00010 & 0000 0010 == 2等情况
                return false;
            } else { // 若为0，将 1 << index 对应的字符加入num中，即原来num = 2
                // 表示num中包含字母 b，此时 index = 0， 1 << index 表示字母 a
                // num |= (1 << index) 为 3（... 0000 0011），表示将 a 也加入num中，
                // 此时num中包含 a 和 b ，若再遇到 index = 0 的情况，num & (1 << index) == 1 不等于 0，
                // 表示 a 已存在，返回false
                int i2 = 1 << index;
                num |= i2;
            }
        }
        return true;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
