package study.leetcode.BFirst;
/*
 * @lc app=leetcode.cn id=2589 lang=java
 *
 * [2589] 完成所有任务的最少时间  困难
 */

// @lc code=start

import java.util.Arrays;

class B2589完成所有任务的最少时间 {
    public static void main(String[] args) {
        // int[][] tasks = { { 1, 3, 2 }, { 2, 5, 3 }, { 5, 6, 2 } };
        // int[][] tasks = { { 2, 3, 1 }, { 4, 5, 1 }, { 1, 5, 2 } };
        // int[][] tasks = { { 2, 13, 2 }, { 6, 18, 5 }, { 2, 13, 3 } }; // 5
        // int[][] tasks = { { 10, 18, 2 }, { 1, 8, 1 }, { 10, 20, 8 } }; // 9
        int[][] tasks = { { 1, 10, 7 }, { 4, 11, 1 }, { 3, 19, 7 }, { 10, 15, 2 } }; // 9[1,10,7],[4,11,1],[3,19,7],[10,15,2]
        System.out.println(new B2589完成所有任务的最少时间().findMinimumTime2(tasks));
    }

    public int findMinimumTime(int[][] tasks) {
        int left = tasks[0][0];
        int right = tasks[0][1];
        int res = tasks[0][2];
        int tab = 0;
        for (int i = 1; i < tasks.length; i++) {
            int l2 = tasks[i][0];
            int r2 = tasks[i][1];
            // 计算重合区间
            int time = tasks[i][2];
            if (time > res) {
                res = time;
                left = left <= l2 ? left : l2;
                right = right >= r2 ? right : r2;
                continue;
            }
            if (r2 < left) {
                tab++;
                left = left <= l2 ? left : l2;
                right = right >= r2 ? right : r2;
                continue;
            }
            int count = right - l2 + 1 > 0 ? right - l2 + 1 : 0;
            res += time - count > 0 ? time - count : 0;
            left = left <= l2 ? left : l2;
            right = right >= r2 ? right : r2;
        }
        return res + tab;
    }

    public int findMinimumTime1(int[][] tasks) {
        int left = tasks[0][0];
        int right = tasks[0][1];
        int res = tasks[0][2];
        for (int i = 1; i < tasks.length; i++) {
            int l2 = tasks[i][0];
            int r2 = tasks[i][1];
            // 计算重合区间

            int time = tasks[i][2];
            if (time > res) {
                res = time;
                left = left <= l2 ? left : l2;
                right = right >= r2 ? right : r2;
                continue;
            }

            int count = right - l2 + 1 > 0 ? right - l2 + 1 : 0;
            res += time - count > 0 ? time - count : 0;
            left = left <= l2 ? left : l2;
            right = right >= r2 ? right : r2;
        }
        return res;
    }

    public int findMinimumTime2(int[][] tasks) {
        // 数组长度
        int n = tasks.length;
        // 对end进行排序
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        // 记录出现过的运行位置
        int[] run = new int[tasks[n - 1][1] + 1];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int start = tasks[i][0], end = tasks[i][1], duration = tasks[i][2];
            // 遍历寻找重合的运行位置，找到之后将本次运行时间减1；
            for (int j = start; j <= end; j++) {
                duration -= run[j];
            }
            // 加上本次运行时间，小于0则取0
            res += Math.max(duration, 0);
            // 根据end倒序遍历，记录run的位置
            for (int j = end; j >= 0 && duration > 0; j--) {
                if (run[j] == 0) {
                    duration--;
                    run[j] = 1;
                }
            }
        }
        return res;
    }
}
// @lc code=end
