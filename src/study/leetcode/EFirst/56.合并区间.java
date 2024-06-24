/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution56 {
    public static void main(String[] args) {
        int[][] intervals = {
                { 2, 3 },
                { 5, 5 },
                { 2, 2 },
                { 3, 4 },
                { 3, 4 },
        };
        System.out.println(Arrays.toString(new Solution56().merge(intervals)));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            int temp = merged.size() != 0 ? merged.get(merged.size() - 1)[1] : 0;
            if (merged.size() == 0 || temp < L) {
                merged.add(new int[] { L, R });
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(temp, R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public int[][] merge1(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        int[][] temp = new int[intervals.length][2];
        Arrays.fill(temp, new int[2]);
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] arr1 = intervals[i - 1];
            int[] arr2 = intervals[i];
            int[] tag = { arr1[0], arr1[1] };
            boolean flag = false;
            while (i < intervals.length && arr1[1] >= arr2[0]) {
                tag[1] = arr2[1] > arr1[1] ? arr2[1] : arr1[1];
                i++;
                flag = true;
                arr1 = arr1[1] > intervals[i - 1][1] ? arr1 : intervals[i - 1];
                arr2 = i == intervals.length ? null : intervals[i];
            }
            temp[index++] = tag;
            if (!flag) {
                temp[index++] = arr2;
            }
        }
        int[][] firstFourElements = new int[index][2];
        System.arraycopy(temp, 0, firstFourElements, 0, index);
        return firstFourElements;
    }
}
// @lc code=end
