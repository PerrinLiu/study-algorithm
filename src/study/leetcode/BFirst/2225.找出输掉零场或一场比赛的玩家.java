package study.leetcode.BFirst;
/*
 * @lc app=leetcode.cn id=2225 lang=java
 *
 * [2225] 找出输掉零场或一场比赛的玩家
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

class Solution2225 {
    public static void main(String[] args) {
        int[][] matches = { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5
        }, { 4, 8 }, { 4, 9 }, { 10, 4 },
                { 10, 9 } };

        // int[][] matches = { { 2, 3 }, { 1, 3 }, { 5, 4 }, { 6, 4 } };
        System.out.println(new Solution2225().findWinners1(matches));
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int[] match : matches) {
            int winner = match[0], loser = match[1];
            freq.putIfAbsent(winner, 0);
            freq.put(loser, freq.getOrDefault(loser, 0) + 1);
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < 2; ++i) {
            ans.add(new ArrayList<Integer>());
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (value < 2) {
                ans.get(value).add(key);
            }
        }

        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }

    public List<List<Integer>> findWinners2(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> winner = new ArrayList<>();
        List<Integer> loser = new ArrayList<>();
        Collections.addAll(res, winner, loser);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] arr : matches) {
            int num1 = arr[0];
            int num2 = arr[1];
            map.putIfAbsent(num1, 0);
            map.put(num2, map.getOrDefault(num2, 0) + 1);
        }
        for (Integer keySet : map.keySet()) {
            if (map.get(keySet) == 0) {
                winner.add(keySet);
            } else if (map.get(keySet) == 1) {
                loser.add(keySet);
            }
        }
        Collections.sort(winner);
        Collections.sort(loser);
        return res;
    }

    public List<List<Integer>> findWinners1(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> treeSet1 = new TreeSet<>();
        TreeSet<Integer> treeSet2 = new TreeSet<>();
        for (int[] arr : matches) {
            int num1 = arr[0];
            int num2 = arr[1];
            treeSet2.add(num2);
            if (map.get(num1) == null) {
                map.put(num1, 0);
                treeSet1.add(num1);
            }
            Integer tab = map.get(num2);
            if (tab == null) {
                map.put(num2, 1);
            } else {
                map.put(num2, tab + 1);
            }
            if (map.get(num2) == 1) {
                treeSet1.remove(num2);
            } else if (map.get(num2) > 1) {
                treeSet2.remove(num2);
            }
        }
        List<Integer> winner = new ArrayList<>(treeSet1);
        List<Integer> loser = new ArrayList<>(treeSet2);
        Collections.addAll(res, winner, loser);
        return res;
    }
}
// @lc code=end
