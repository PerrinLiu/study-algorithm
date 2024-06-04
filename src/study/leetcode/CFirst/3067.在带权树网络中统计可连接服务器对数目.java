package study.leetcode.CFirst;
/*
 * @lc app=leetcode.cn id=3067 lang=java
 *
 * [3067] 在带权树网络中统计可连接服务器对数目
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution3067 {
    public static void main(String[] args) {
        int[][] edges = { { 0, 1, 1 }, { 1, 2, 5 }, { 2, 3, 13 }, { 3, 4, 9 }, { 4, 5, 2 } };
        int signalSpeed = 1;
        System.out.println(Arrays.toString(new Solution3067().countPairsOfConnectableServers(edges, signalSpeed)));
    }

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int wt = e[2];
            g[x].add(new int[] { y, wt });
            g[y].add(new int[] { x, wt });
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int[] e : g[i]) {
                int cnt = dfs(e[0], i, e[1], g, signalSpeed);
                ans[i] += cnt * sum;
                sum += cnt;
            }
        }
        return ans;
    }

    private int dfs(int x, int fa, int sum, List<int[]>[] g, int signalSpeed) {
        int cnt = sum % signalSpeed == 0 ? 1 : 0;
        for (int[] e : g[x]) {
            int y = e[0];
            if (y != fa) {
                cnt += dfs(y, x, sum + e[1], g, signalSpeed);
            }
        }
        return cnt;
    }

}
// @lc code=end
