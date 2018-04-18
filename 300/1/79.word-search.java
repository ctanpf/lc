/*
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (28.13%)
 * Total Accepted:    174.6K
 * Total Submissions: 620.9K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * 
 * 
 * For example,
 * Given board = 
 * 
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * 
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && check(board, i, j, 0, word, visited)) return true;
            }
        }

        return false;
    }

    public boolean check(char[][] board, int i, int j, int idx, String word, boolean[][] visited) {
        if (idx == word.length()) return true;
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 ||
        visited[i][j] || board[i][j] != word.charAt(idx)) return false;
        visited[i][j] = true;
        if (
            check(board, i + 1, j, idx + 1, word, visited) ||
            check(board, i - 1, j, idx + 1, word, visited) ||
            check(board, i, j + 1, idx + 1, word, visited) ||
            check(board, i, j - 1, idx + 1, word, visited)         
        ) return true;
        visited[i][j] = false;
        return false;
        
    }
}
