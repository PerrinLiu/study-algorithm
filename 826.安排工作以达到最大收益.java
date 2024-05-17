/*
 * @lc app=leetcode.cn id=826 lang=java
 *
 * [826] 安排工作以达到最大收益
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

class Solution {
    public static void main(String[] args) {
        // int[] arr1 = { 2, 4, 6, 8, 10 };
        // int[] arr2 = { 10, 20, 30, 40, 50 };
        // int[] arr3 = { 4, 5, 6, 7 };
        int[] arr1 = { 68, 35, 52, 47, 86 };
        int[] arr2 = { 67, 17, 1, 81, 3 };
        int[] arr3 = { 92, 10, 85, 84, 82 };
        // int[] arr1 = { 5, 50, 92, 21, 24, 70, 17, 63, 30, 53 };
        // int[] arr2 = { 68, 100, 3, 99, 56, 43, 26, 93, 55, 25 };
        // int[] arr3 = { 96, 3, 55, 30, 11, 58, 68, 36, 26, 1 };
        System.out.println(new Solution().maxProfitAssignment2(arr1, arr2, arr3));
    }

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        sortDifficulty(difficulty, profit);
        int res = 0;
        Arrays.sort(worker);
        int tab = difficulty.length - 1;
        for (int i = worker.length - 1; i >= 0; i--) {
            int num = worker[i];
            if (num < difficulty[0]) {
                continue;
            }
            if (num >= difficulty[difficulty.length - 1]) {
                res += map.get(difficulty[difficulty.length - 1]);
                continue;
            }
            if (map.get(num) != null) {
                res += map.get(num);
                continue;
            }
            while (difficulty[tab] > num) {
                tab--;
            }
            res += map.get(difficulty[tab]);
        }
        return res;
    }

    public void sortDifficulty(int[] difficulty, int[] profit) {
        for (int i = 0; i < difficulty.length; i++) {
            if (map.containsKey(difficulty[i])) {
                profit[i] = map.get(difficulty[i]) > profit[i] ? map.get(difficulty[i]) : profit[i];
            }
            map.put(difficulty[i], profit[i]);
        }
        Arrays.sort(difficulty);
        for (int i = 0; i < difficulty.length - 1; i++) {
            if (map.get(difficulty[i]) > map.get(difficulty[i + 1])) {
                map.put(difficulty[i + 1], map.get(difficulty[i]));
            }
        }
        // for (int i = difficulty.length - 1; i >= 0; i--) {
        // if (i >= 1) {
        // int left = difficulty[i - 1] + 1;
        // int right = difficulty[i];
        // while (left < right) {
        // map.put(left++, map.get(difficulty[i - 1]));
        // }
        // }
        // }
    }

    public int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) {
        int[] maxProfit = new int[100001];
        // 对 difficulty 去重，得到每个 difficulty 数值的最大 profit
        for (int i = 0; i < difficulty.length; i++) {
            if (maxProfit[difficulty[i]] < profit[i])
                maxProfit[difficulty[i]] = profit[i];
        }
        int max = 0;
        // 对每个 difficulty，记录 <= difficulty 的最大 profit
        for (int i = 0; i < maxProfit.length; i++) {
            if (maxProfit[i] < max)
                maxProfit[i] = max;
            else
                max = maxProfit[i];
        }
        int ans = 0;
        for (int i : worker) {
            ans += maxProfit[i];
        }
        return ans;
    }

    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        int ans = 0, j = 0, maxProfit = 0;
        for (int w : worker) {
            while (j < n && jobs[j][0] <= w) {
                maxProfit = Math.max(maxProfit, jobs[j++][1]);
            }
            ans += maxProfit;
        }
        return ans;
    }
}
// @lc code=end
