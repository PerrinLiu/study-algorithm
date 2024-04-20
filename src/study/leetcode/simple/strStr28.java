package study.leetcode.simple;

/**
 * str str28
 *
 * @author llpy
 * @date 2024/04/20
 */
public class strStr28 {

//    28. 找出字符串中第一个匹配项的下标
//            简单
//    相关标签
//            相关企业
//    给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
//
//
//
//    示例 1：
//
//    输入：haystack = "sadbutsad", needle = "sad"
//    输出：0
//    解释："sad" 在下标 0 和 6 处匹配。
//    第一个匹配项的下标是 0 ，所以返回 0 。
//    示例 2：
//
//    输入：haystack = "leetcode", needle = "leeto"
//    输出：-1
//    解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
    public static void main(String[] args) {
        String one ="leetcode";
        String two = "leeto";
        System.out.println(strStr(one,two));
    }

    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for(int i = 0;i+m <= n;i++){
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
}
