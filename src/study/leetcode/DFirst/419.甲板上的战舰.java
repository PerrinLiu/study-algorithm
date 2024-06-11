/*
 * @lc app=leetcode.cn id=419 lang=java
 *
 * [419] 甲板上的战舰
 */

// @lc code=start
class Solution419 {
    public static void main(String[] args) {
        char[][] board = {
                { 'X', '.', 'X', 'X' },
                { '.', 'X', '.', 'X' },
                { '.', '.', '.', 'X' },
                { 'X', '.', 'X', '.' },

        };
        System.out.println(new Solution419().countBattleships(board));
    }

    public int countBattleships(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }

                    res++;
                }

            }
        }
        return res;
    }

    public int countBattleships1(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                boolean falg = (i > 0 && board[i - 1][j] == c) || (j > 0 && board[i][j - 1] == c);
                if (c == 'X' && !falg) {
                    res++;
                }
            }
        }
        return res;
    }
}
// @lc code=end
