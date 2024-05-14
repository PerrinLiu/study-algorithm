package study.leetcode.IFirst;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class I970腐烂的橘子 {
    // 994.
    // 腐烂的橘子 中等
    // 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：

    // 值 0 代表空单元格；
    // 值 1 代表新鲜橘子；
    // 值 2 代表腐烂的橘子。
    // 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。

    // 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。

    int[] dr = new int[] { -1, 0, 1, 0 };
    int[] dc = new int[] { 0, -1, 0, 1 };

    // 示例 1：

    // 输入：grid=[[2,1,1],[1,1,0],[0,1,1]]

    // 输出：4
    // 示例 2：

    // 输入：grid=[[2,1,1],[0,1,1],[1,0,1]]
    // 输出：-1
    // 解释：左下角的橘子（第 2 行，第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
    // 示例 3：

    // 输入：grid=[[0,2]]
    // 输出：0
    // 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0。

    // 提示：

    // m==grid.length
    // n==grid[i].length
    // 1<=m,n<=10
    // grid[i][j]仅为 0、1 或 2
    public static void main(String[] args) {
        // [2,1,1]
        // [0,1,1]
        // [1,0,1]

        // [2,1,1]
        // [1,1,0]
        // [0,1,1]
        int[][] grid = { { 1, 1, 1 }, { 1, 2, 1 }, { 1, 1, 1 } };
        System.out.println(orangesRotting1(grid));
    }

    public static int orangesRotting1(int[][] grid) {
        int[] dr = new int[] { -1, 0, 1, 0 };
        int[] dc = new int[] { 0, -1, 0, 1 };
        int R = grid.length, C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        Map<Integer, Integer> depth = new HashMap<Integer, Integer>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            // 检查相邻四个方向
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                // 如果相邻单元格有新鲜橘子,则标记为腐烂
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    res = depth.get(ncode);
                }
            }
        }
        // 检查是否还有新鲜橘子
        for (int[] row : grid) {
            for (int v : row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return res;
    }

    public static int orangesRotting(int[][] grid) {
        int count = 0;
        int newOrange = 0;
        HashMap<String, Integer> map = new HashMap<>();
        // 相邻4个方向，也就是上下左右,
        // 如int[i][j]，对应的是,
        // int[i-1][j] 上
        // int[i+1][j] 下
        // int[i][j-1] 左
        // int[i][j+1] 右
        // i对应的边界为，i等于0或i等于m-1。
        // j对应的边界为，j等于0或j等于n-1。
        // 如果当前值为2且相邻的值不为0，则将其更新为2，并重新将该二维数组进行递归
        int iLen = grid.length;
        int jLen = grid[0].length;
        for (int i = 0; i < iLen; i++) {
            for (int j = 0; j < jLen; j++) {
                int temp = grid[i][j];
                if (temp == 2) {
                    map.put(i + "-" + j, 2);
                } else if (temp == 1) {
                    newOrange++;
                }
            }
        }
        int index = newOrange;

        while (newOrange != 0 && index > 0) {
            HashMap<String, Integer> map2 = new HashMap<>(map);
            for (String keySet : map.keySet()) {
                if (map.get(keySet) == 1) {
                    continue;
                }
                String[] split = keySet.split("-");
                int i = Integer.parseInt(split[0]), j = Integer.parseInt(split[1]);
                String up = i != 0 ? (i - 1) + "-" + j : keySet;
                String down = i != iLen - 1 ? (i + 1) + "-" + j : keySet;
                String left = j != 0 ? i + "-" + (j - 1) : keySet;
                String right = j != jLen - 1 ? i + "-" + (j + 1) : keySet;
                newOrange = isPut(up, grid, map2, newOrange);
                newOrange = isPut(down, grid, map2, newOrange);
                newOrange = isPut(left, grid, map2, newOrange);
                newOrange = isPut(right, grid, map2, newOrange);
                map2.put(keySet, 1);
            }
            map = map2;
            index--;
            count++;
        }

        return newOrange > 0 ? -1 : count;
    }

    public static int isPut(String str, int[][] grid, HashMap<String, Integer> map2, int newOrange) {
        String[] split = str.split("-");
        int i = Integer.parseInt(split[0]), j = Integer.parseInt(split[1]);
        if (grid[i][j] == 1) {
            grid[i][j] = 2;
            map2.put(str, 2);
            newOrange--;
        }
        return newOrange;
    }
}
