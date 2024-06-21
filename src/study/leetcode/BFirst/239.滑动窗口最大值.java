/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

class Solution239 {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 1, 2, 0, 5 };
        int k = 3;
        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow3(nums, k)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>(); // 双端队列
        for (int i = 0; i < n; i++) {
            // 1. 入
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast(); // 维护 q 的单调性
            }
            q.addLast(i); // 入队
            // 2. 出
            if (i - q.getFirst() >= k) { // 队首已经离开窗口了
                q.removeFirst();
            }
            // 3. 记录答案
            if (i >= k - 1) {
                // 由于队首到队尾单调递减，所以窗口最大值就是队首
                ans[i - k + 1] = nums[q.getFirst()];
            }
        }
        return ans;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[] { nums[i], i });
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[] { nums[i], i });
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.MIN_VALUE;
        }
        int[] sortK = new int[k];
        System.arraycopy(nums, 0, sortK, 0, k);
        Arrays.sort(sortK);
        res[0] = sortK[sortK.length - 1];
        int temp = sortK[sortK.length - 2];

        for (int i = 1; i < res.length; i++) {
            if (res[i - 1] == nums[i - 1]) {
                res[i] = Math.max(temp, nums[i - 1 + k]);
                System.arraycopy(nums, i, sortK, 0, k);
                Arrays.sort(sortK);
                temp = sortK[sortK.length - 2];
            } else {
                res[i] = Math.max(res[i - 1], nums[i - 1 + k]);
            }
        }
        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = 0; j < k; j++) {
                res[i] = Math.max(res[i], nums[i + j]);
            }
        }
        return res;
    }
}
// @lc code=end
