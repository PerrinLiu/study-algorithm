package study.leetcode.twoFirst;
/*
 * @lc app=leetcode.cn id=2391 lang=java
 *
 * [2391] 收集垃圾的最少总时间
 */

public class B2391Solution {

    public static void main(String[] args) {
        B291 solution = new B291();
        String[] strs = { "G", "P", "GP", "GG" };
        int[] travel = { 2, 4, 3 };
        System.out.println(solution.garbageCollection2(strs, travel));
        System.out.println(solution.garbageCollection3(strs, travel));
        System.out.println(solution.garbageCollection4(strs, travel));
    }

}
// @lc code=end

class B291 {
    public int garbageCollection2(String[] garbage, int[] travel) {
        int n = garbage.length;
        int t1 = 0, time1 = 0;
        int t2 = 0, time2 = 0;
        int t3 = 0, time3 = 0;

        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                temp += travel[i - 1];
            }
            for (int j = 0; j < garbage[i].length(); j++) {
                if (garbage[i].charAt(j) == 'M') {
                    t1 = temp + t1 + 1 - time1;
                    time1 = temp;
                } else if (garbage[i].charAt(j) == 'P') {
                    t2 = temp + t2 + 1 - time2;
                    time2 = temp;
                } else if (garbage[i].charAt(j) == 'G') {
                    t3 = temp + t3 + 1 - time3;
                    time3 = temp;
                }
            }
        }

        return t1 + t2 + t3;
    }

    public int garbageCollection3(String[] garbage, int[] travel) {
        // 垃圾的总个数、到达指定房子的行驶时间
        int count = 0, temp = 0;
        // 记录当前每个垃圾车的时间 M P G
        int time1 = 0, time2 = 0, time3 = 0;
        for (int i = 0; i < garbage.length; i++) {
            // 有多少个垃圾就需要多少分钟，累加到总时间
            count += garbage[i].length();
            // 累加到达房子的行驶时间
            temp = i > 0 ? temp + travel[i - 1] : 0;
            // 根据垃圾类型，更新总时间
            // 例如垃圾为M
            // 1.新的收集总时间 = 当前收集总时间 + 到达指定房子行驶时间（temp） - 到达上一房子的所需行驶时间（time1）
            // 2.然后将到达上一房子的所需行驶时间 更新 为到达指定房子的行驶时间,也就是time1更新为temp
            // 当下次再遇到垃圾M时，重复1，2
            for (char c : garbage[i].toCharArray()) {
                if (c == 'M') {
                    time1 = temp;
                } else if (c == 'P') {
                    time2 = temp;
                } else if (c == 'G') {
                    time3 = temp;
                }
            }
        }
        return time1 + time2 + time3 + count;
    }

    public int garbageCollection4(String[] garbage, int[] travel) {
        int ans = 0;
        for (String g : garbage) {
            ans += g.length();
        }
        for (int t : travel) {
            ans += t * 3;
        }
        for (char c : new char[] { 'M', 'P', 'G' }) {
            for (int i = garbage.length - 1; i > 0 && garbage[i].indexOf(c) < 0; i--) {
                ans -= travel[i - 1]; // 没有垃圾 c，多跑了
            }
        }
        return ans;
    }
}
