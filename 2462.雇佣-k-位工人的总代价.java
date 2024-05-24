/*
 * @lc app=leetcode.cn id=2462 lang=java
 *
 * [2462] 雇佣 K 位工人的总代价
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        // int[] costs = { 17, 12, 10, 2, 7, 2, 11, 20, 8 };
        // int[] costs = { 93, 287, 44, 470, 755, 720, 147, 917, 624, 373, 138, 498,
        // 207, 465, 826, 975, 158, 636, 436,
        // 640, 271, 827, 975, 447, 409, 253, 416, 456, 71, 150, 530, 4, 638, 716, 44,
        // 662, 872, 541, 265, 202 };
        int[] costs = { 28, 35, 21, 13, 21, 72, 35, 52, 74, 92, 25, 65, 77, 1, 73, 32, 43, 68, 8, 100, 84, 80, 14, 88,
                42, 53, 98, 69, 64, 40, 60, 23, 99, 83, 5, 21, 76, 34 };
        int k = 32;
        int candidates = 2;
        System.out.println(new Solution().totalCost2(costs, k, candidates));
    }

    public long totalCost(int[] costs, int k, int candidates) {
        int len = costs.length;
        int pre = 0;
        int suff = len - 1;
        TreeMap<Integer, List<Integer>> map1 = new TreeMap<>();
        TreeMap<Integer, List<Integer>> map2 = new TreeMap<>();
        for (int i = 0; i < candidates; i++) {
            List<Integer> l1 = map1.getOrDefault(costs[pre], new ArrayList<>());
            List<Integer> l2 = map2.getOrDefault(costs[suff], new ArrayList<>());
            l1.add(pre);
            l2.add(suff);
            map1.put(costs[pre++], l1);
            map2.put(costs[suff--], l2);
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int costs2 : costs) {
            map.put(costs2, map.getOrDefault(costs2, 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            if (candidates >= len - i) {
                for (Entry<Integer, Integer> entrySet : map.entrySet()) {
                    res += entrySet.getKey();
                    if (i++ >= k) {
                        break;
                    }
                }
                break;
            }
            Integer firstKey = map1.firstKey();
            Integer firstKey2 = map2.firstKey();
            Entry<Integer, List<Integer>> firstEntry1 = map1.firstEntry();
            Entry<Integer, List<Integer>> firstEntry2 = map2.firstEntry();
            if (firstEntry1.getKey() <= firstEntry2.getKey()) {
                List<Integer> value = firstEntry1.getValue();
                if (value.size() == 1) {
                    map1.remove(firstEntry1.getKey());
                } else {
                    value.remove(0);
                }
                List<Integer> orDefault = map1.getOrDefault(costs[pre], new ArrayList<>());
                orDefault.add(pre);
                map1.put(costs[pre++], orDefault);
                res += firstEntry1.getKey();
                if (map.get(firstKey) - 1 == 0) {
                    map.remove(firstKey);
                } else {
                    map.put(firstKey, map.get(firstKey) - 1);
                }
            } else {
                List<Integer> value = firstEntry2.getValue();
                if (value.size() == 1) {
                    map2.remove(firstEntry2.getKey());
                } else {
                    value.remove(0);
                }
                List<Integer> orDefault = map2.getOrDefault(costs[suff], new ArrayList<>());
                orDefault.add(suff);
                map2.put(costs[suff--], orDefault);
                res += firstEntry2.getKey();
                if (map.get(firstKey2) - 1 == 0) {
                    map.remove(firstKey2);
                } else {
                    map.put(firstKey2, map.get(firstKey2) - 1);
                }
            }
        }

        return res;
    }

    public long totalCost1(int[] costs, int k, int candidates) {
        int len = costs.length;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            List<Integer> orDefault = map.getOrDefault(costs[i], new ArrayList<Integer>());
            orDefault.add(i);
            map.put(costs[i], orDefault);
        }
        int res = 0;
        int[] prefix = new int[candidates];
        int[] suffix = new int[candidates];
        int pre = candidates;
        int suff = len - candidates - 1;
        System.arraycopy(costs, 0, prefix, 0, candidates);
        System.arraycopy(costs, len - candidates, suffix, 0, candidates);
        Arrays.sort(prefix);
        Arrays.sort(suffix);
        for (int i = 0; i < k; i++) {
            if (candidates >= len - i) {
                for (Integer keySet : map.keySet()) {
                    res += keySet;
                    map.get(keySet).remove(0);
                    if (map.get(keySet).isEmpty()) {
                        map.remove(keySet);
                    }
                    break;
                }
                continue;
            }
            while (true) {
                int number = Math.min(prefix[0], suffix[0]);
                if (prefix[0] <= suffix[0]) {
                    prefix[0] = costs[pre++];
                    Arrays.sort(prefix);
                } else {
                    suffix[0] = costs[suff--];
                    Arrays.sort(suffix);
                }
                if (map.get(number) != null) {
                    res += number;
                    map.get(number).remove(0);
                    if (map.get(number).isEmpty()) {
                        map.remove(number);
                    }
                    break;
                }

            }
        }
        return res;
    }

    public long totalCost2(int[] costs, int k, int candidates) {
        int n = costs.length;
        long ans = 0;
        if (candidates * 2 + k > n) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                ans += costs[i];
            }
            return ans;
        }

        PriorityQueue<Integer> pre = new PriorityQueue<>();
        PriorityQueue<Integer> suf = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) {
            pre.offer(costs[i]);
            suf.offer(costs[n - 1 - i]);
        }

        int i = candidates;
        int j = n - 1 - candidates;
        while (k-- > 0) {
            if (pre.peek() <= suf.peek()) {
                ans += pre.poll();
                pre.offer(costs[i++]);
            } else {
                ans += suf.poll();
                suf.offer(costs[j--]);
            }
        }
        return ans;
    }
}
// @lc code=end
