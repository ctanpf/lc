/*
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (19.67%)
 * Total Accepted:    101.1K
 * Total Submissions: 513.8K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * 
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * 
 * 
 * For example,
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * 
 * 
 * After running your function, the board should be:
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 */
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == m - 1 || j == n - 1)) {
                    check(board, i, j);
                }
            }
        }

        for (char[] b : board) {
            for (int i = 0; i < n; i++) {
                if (b[i] == 'O') b[i] = 'X';
                else if (b[i] == '1') b[i] = 'O';
            }
        }
    }

    public void check(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != 'O') return;
        board[i][j] = '1';
        check(board, i + 1, j);
        check(board, i - 1, j);
        check(board, i, j + 1);
        check(board, i, j - 1);
    }
}
