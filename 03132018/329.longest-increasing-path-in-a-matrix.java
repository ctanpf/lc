/*
 * [329] Longest Increasing Path in a Matrix
 *
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
 *
 * algorithms
 * Hard (37.34%)
 * Total Accepted:    49.7K
 * Total Submissions: 133.2K
 * Testcase Example:  '[[9,9,4],[6,6,8],[2,1,1]]'
 *
 * Given an integer matrix, find the length of the longest increasing path.
 * 
 * 
 * From each cell, you can either move to four directions: left, right, up or
 * down. You may NOT move diagonally or move outside of the boundary (i.e.
 * wrap-around is not allowed).
 * 
 * 
 * Example 1:
 * 
 * nums = [
 * ⁠ [9,9,4],
 * ⁠ [6,6,8],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 * 
 * 
 * Return 4
 * 
 * The longest increasing path is [1, 2, 6, 9].
 * 
 * 
 * Example 2:
 * 
 * nums = [
 * ⁠ [3,4,5],
 * ⁠ [3,2,6],
 * ⁠ [2,2,1]
 * ]
 * 
 * 
 * 
 * 
 * Return 4
 * 
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not
 * allowed.
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int res = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j, dp));
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j];
        int max = 1;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[0].length - 1 || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, dp);
            max = Math.max(max, len);
        }
        dp[i][j] = max;
        return max;
    }
}
