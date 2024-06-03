package study.leetcode.AFirst;
/*
 * @lc app=leetcode.cn id=1103 lang=java
 *
 * [1103] 分糖果 II
 */

// @lc code=start
class Solution1103 {
    public static void main(String[] args) {
        System.out.println(new Solution1103().distributeCandies(10, 3));
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int number = 1;
        while (candies > 0) {
            for (int i = 0; i < res.length; i++) {
                if (number >= candies) {
                    res[i] += candies;
                    candies = 0;
                    break;
                }
                res[i] += number;
                candies -= number++;
            }
        }
        return res;
    }
}
// @lc code=end
