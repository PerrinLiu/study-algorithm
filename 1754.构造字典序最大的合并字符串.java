/*
 * @lc app=leetcode.cn id=1754 lang=java
 *
 * [1754] 构造字典序最大的合并字符串  中等
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // String largestMerge = solution.largestMerge("ddddddddydvdddvvdddf",
        // "yydyyyyyyfyydyyfyyyydfyd");

        String largestMerge = solution.largestMerge1("cabaa", "bcaaa");
        // String largestMerge = solution.largestMerge("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb",
        // "bbbbbbbbbbbbbbbbbbbb");
        // String largestMerge = solution.largestMerge("olnllnxlxllllllllllnlelllex",
        // "oooooooooooooooooo");
        // String largestMerge = solution.largestMerge("tppp",
        // "tppt");
        System.out.println(largestMerge);
    }

    public String largestMerge1(String word1, String word2) {
        StringBuilder merge = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length() && word1.substring(i).compareTo(word2.substring(j)) > 0) {
                merge.append(word1.charAt(i));
                i++;
            } else {
                merge.append(word2.charAt(j));
                j++;
            }
        }
        return merge.toString();
    }

    public String largestMerge(String word1, String word2) {
        // w1,w2比较，直到一个大的数出现，否则一直＋1比较，比较完成后，重新归0，进行比较
        StringBuilder merge = new StringBuilder();
        int w1 = 0;
        int w2 = 0;
        int sum1 = 0;
        int sum2 = 0;
        while (word1.length() > 0 || word2.length() > 0) {
            int index = 1;
            if (word1.length() == 0) {
                merge.append(word2);
                break;
            }
            if (word2.length() == 0) {
                merge.append(word1);
                break;
            }
            sum1 += w1 <= word1.length() - 1 ? word1.charAt(w1) : Integer.MIN_VALUE;
            sum2 += w2 <= word2.length() - 1 ? word2.charAt(w2) : Integer.MIN_VALUE;
            if (sum1 == sum2 && word1.length() == 1 && word2.length() == 1) {
                merge.append(word1).append(word2);
                break;
            }
            if (sum1 == sum2) {
                w1++;
                w2++;
                continue;
            }
            if (sum1 > sum2) {
                while (index <= word1.length() - 1 && word1.charAt(index - 1) <= word1.charAt(index)) {
                    index++;
                }
                merge.append(word1.substring(0, index));
                word1 = word1.substring(index, word1.length());
            } else {
                while (index <= word2.length() - 1 && word2.charAt(index - 1) <= word2.charAt(index)) {
                    index++;
                }
                merge.append(word2.substring(0, index));
                word2 = word2.substring(index, word2.length());
            }
            index = 0;
            sum1 = 0;
            sum2 = 0;
            w1 = 0;
            w2 = 0;
        }
        return merge.toString();
    }
}
// @lc code=end
