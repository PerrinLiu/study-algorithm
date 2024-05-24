package study.leetcode.BFirst;
/*
 * @lc app=leetcode.cn id=2831 lang=java
 *
 * [2831] 找出最长等值子数组
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Solution2831 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 3, 2, 3, 1, 3);
        Collections.addAll(list, 1, 1, 2, 2, 1, 1);
        Collections.addAll(list, 2, 2, 3, 2, 1, 1, 1, 1, 1, 1);
        Collections.addAll(list, 1, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1, 2, 2, 2, 2, 2);
        // Collections.addAll(list, 1);
        int k = 3;
        System.out.println(new Solution2831().longestEqualSubarray5(list, k));
    }

    public int longestEqualSubarray4(List<Integer> nums, int k) {
        int n = nums.size();
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        for (List<Integer> vec : pos.values()) {
            for (int i = 0, j = 0; i < vec.size(); i++) {
                /* 缩小窗口，直到不同元素数量小于等于 k */
                while (vec.get(i) - vec.get(j) - (i - j) > k) {
                    j++;
                }
                ans = Math.max(ans, i - j + 1);
            }
        }
        return ans;
    }

    public int longestEqualSubarray6(List<Integer> nums, int k) {
        // 网友的一次遍历改进版，最快版
        int n = nums.size();
        int[] nc = new int[n + 10]; // 存对应数字能出现的次数-->整个最大的长度
        int mc = 0, i = 0, j = 0;
        while (i < n) {
            int num = nums.get(i++);
            nc[num]++; // 出现一次数字加该数字1的长度
            mc = Math.max(nc[num], mc); // 得到目前众数是谁 --> 最大长度
            if (mc + k < i - j) {// 历史最长的长度配合可以删除的个数k小于两个数字之差即符合要求，如果i继续加却无法增加众数数量，就只能又移动左端
                // 这种写法与始终维持众数长度，以最长能存多少考虑，再去比较大小的方法，数据操作减少。一旦mc变大，就意味着更新最大的数(这个数可能和原来的一样)
                // 因为最后返回的也是最长，所以无影响
                // 答案中是将最左端数值看成众数时，这个窗口最长能为多少，用while循环处理
                // if(nc[nums.get(j)]+k<i-j){ //就会变成和答案差不多的方法（把最左端看成众数）
                nc[nums.get(j++)]--; // 减少滑动窗口的最左端对应数字的长度
                /*
                 * 如果当前窗口中最多的元素加上可以移除的元素数量 k 小于窗口的长度（i - j），
                 * 这意味着窗口内不能通过移除 k 个不同元素达到全部相同的状态，
                 * 因此需要通过移动窗口的左端 j 来缩小窗口，并递减左端元素的计数。
                 * 虽然此时最多的元素，可能发生改变，但不会影响mc的长度
                 */
            }
        }
        return mc;
    }

    public int longestEqualSubarray5(List<Integer> nums, int k) {
        int n = nums.size();
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            cnt.put(nums.get(j), cnt.getOrDefault(nums.get(j), 0) + 1);
            /* 当前区间中，无法以 nums[i] 为等值元素构成合法等值数组 */
            while (j - i + 1 - cnt.get(nums.get(i)) > k) {
                cnt.put(nums.get(i), cnt.get(nums.get(i)) - 1);
                i++;
            }
            ans = Math.max(ans, cnt.get(nums.get(j)));
        }
        return ans;
    }

    public int longestEqualSubarray1(List<Integer> nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            int tab = 1;
            int count = 1;
            int index = i + 1;
            if (i != 0 && num == nums.get(i - 1)) {
                continue;
            }
            while (k >= tab && index < nums.size()) {
                while (k >= tab && index <= nums.size() - 1 && nums.get(index) != num) {
                    tab++;
                    index++;
                }
                while (index <= nums.size() - 1 && nums.get(index) == num) {
                    count++;
                    index++;
                }
            }
            if (k == 0) {
                while (index <= nums.size() - 1 && nums.get(index) == num) {
                    count++;
                    index++;
                }
            }
            res = Math.max(count, res);
            if (res >= (nums.size() - res)) {
                return res;
            }
        }
        return res;
    }

    public int longestEqualSubarray2(List<Integer> nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            if (map.containsKey(nums.get(i))) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            int index = i;
            int tab = 0;
            while (index < nums.size()) {
                if (nums.get(index++).equals(nums.get(i))) {
                    list.add(tab);
                    tab = 0;
                    continue;
                }
                tab++;
            }
            if (list.size() > 1) {
                map.put(nums.get(i), list);
            }
        }
        if (map.size() == 0) {
            return 1;
        }
        int res = 0;
        for (Integer keySet : map.keySet()) {
            List<Integer> list = map.get(keySet);
            if (list.size() <= res) {
                continue;
            }
            for (int i = 0; i < list.size(); i++) {
                int tab = 0;
                int count = 1;
                int index = i + 1;
                while (index < list.size() && tab + list.get(index) <= k) {
                    tab = tab + list.get(index++);
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            if (map.containsKey(nums.get(i))) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            int index = i;
            int tab = 0;
            while (index < nums.size()) {
                if (nums.get(index++).equals(nums.get(i))) {
                    list.add(tab);
                    tab = 0;
                    continue;
                }
                tab++;
            }
            if (list.size() > 1) {
                map.put(nums.get(i), list);
            }
        }
        if (map.size() == 0) {
            return 1;
        }
        // 将 map 转换为 List<Map.Entry<Integer, List<Integer>>>
        List<Map.Entry<Integer, List<Integer>>> list1 = new ArrayList<>(map.entrySet());

        // 对 List 进行排序，根据值（List<Integer>）的长度
        list1.sort(Comparator.comparingInt(entry -> entry.getValue().size()));
        Collections.reverse(list1);
        // 创建一个 LinkedHashMap 保留排序后的顺序
        LinkedHashMap<Integer, List<Integer>> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : list1) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        int res = 0;
        for (Integer keySet : sortedMap.keySet()) {
            List<Integer> list = sortedMap.get(keySet);
            if (list.size() <= res) {
                continue;
            }
            for (int i = 0; i < list.size(); i++) {
                int tab = 0;
                int count = 1;
                int index = i + 1;
                while (index < list.size() && tab + list.get(index) <= k) {
                    tab = tab + list.get(index++);
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
// @lc code=end
