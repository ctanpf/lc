/*
 * [36] Valid Sudoku
 *
 * https://leetcode.com/problems/valid-sudoku/description/
 *
 * algorithms
 * Medium (37.58%)
 * Total Accepted:    151.8K
 * Total Submissions: 403.9K
 * Testcase Example:  '[[".","8","7","6","5","4","3","2","1"],["2",".",".",".",".",".",".",".","."],["3",".",".",".",".",".",".",".","."],["4",".",".",".",".",".",".",".","."],["5",".",".",".",".",".",".",".","."],["6",".",".",".",".",".",".",".","."],["7",".",".",".",".",".",".",".","."],["8",".",".",".",".",".",".",".","."],["9",".",".",".",".",".",".",".","."]]'
 *
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled
 * with the character '.'.
 * 
 * 
 * 
 * A partially filled sudoku which is valid.
 * 
 * 
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only
 * the filled cells need to be validated.
 * 
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] grid = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int val = c - '1';
                    int x = 3 * (i/3) + val/3;
                    int y = 3 * (j/3) + val % 3;
                    if (rows[i][val] || cols[val][j] || grid[x][y]) return false;
                    rows[i][val] = true;
                    cols[val][j] = true;
                    grid[x][y] = true;
                } 
            }
        }
        return true;
    }
}
