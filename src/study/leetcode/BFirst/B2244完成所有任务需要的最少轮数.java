package study.leetcode.BFirst;
/*
 * @lc app=leetcode.cn id=2244 lang=java
 *
 * [2244] 完成所有任务需要的最少轮数
 */

import java.util.Arrays;
import java.util.HashMap;

// @lc code=start
class B2244完成所有任务需要的最少轮数 {
    public static void main(String[] args) {
        int[] task = { 2 };
        B2244完成所有任务需要的最少轮数 b2244 = new B2244完成所有任务需要的最少轮数();
        int minimumRounds = b2244.minimumRounds(task);
        System.out.println(minimumRounds);
    }

    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int res = 0;
        int number = tasks[0];
        int index = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (number == tasks[i]) {
                index++;
                continue;
            }
            res = addRes(index, res);
            if (res == -1) {
                return -1;
            }
            number = tasks[i];
            index = 1;
        }
        res = addRes(index, res);
        return res;
    }

    private int addRes(int index, int res) {
        if (index <= 1) {
            return -1;
        }
        while (index != 0) {
            if (index % 3 != 0) {
                index -= 2;
                res++;
                continue;
            }
            res += index / 3;
            break;
        }
        return res;
    }

    public int minimumRounds1(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int tasks2 : tasks) {
            map.put(tasks2, map.get(tasks2) == null ? 1 : map.get(tasks2) + 1);
        }
        int res = 0;
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (Integer keySet : map.keySet()) {
            Integer integer = map.get(keySet);
            if (integer == 1) {
                return -1;
            }
            int index = integer;
            if (map2.get(index) != null) {
                res += map2.get(integer);
                continue;
            }
            int count = 0;
            while (integer != 0) {
                if (integer % 3 != 0) {
                    integer -= 2;
                    count++;
                    continue;
                }
                count += integer / 3;
                break;
            }
            map2.put(index, count);
            res += count;
        }
        return res;
    }
}
// @lc code=end
