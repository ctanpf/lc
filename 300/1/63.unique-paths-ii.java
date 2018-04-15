/*
 * [63] Unique Paths II
 *
 * https://leetcode.com/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (32.17%)
 * Total Accepted:    133.6K
 * Total Submissions: 415.3K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * 
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * 
 * [
 * ⁠ [0,0,0],
 * ⁠ [0,1,0],
 * ⁠ [0,0,0]
 * ]
 * 
 * 
 * The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 * 
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // return sol(obstacleGrid);
        return sol2(obstacleGrid);
    }

    public int sol(int[][] obs) {
        if (obs == null || obs.length == 0) return 0;
        int m = obs.length;
        int n = obs[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = obs[0][0] ^ 1;
        for (int i = 1; i < m; i++) {
            if (obs[i][0] == 0) dp[i][0] = dp[i - 1][0]; 
        }
        for (int j = 1; j < n; j++) {
            if (obs[0][j] == 0) dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obs[i][j] == 0) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    
    public int sol2(int[][] obs) {
        if (obs == null || obs.length == 0) return 0;
        int m = obs.length;
        int n = obs[0].length;
        int[] dp = new int[n];
        dp[0] = obs[0][0] ^ 1;

        for (int[] d : obs) {
            for (int i = 0; i < n; i++) {
                if (d[i] == 1) dp[i] = 0;
                else if (i > 0) dp[i] += dp[i - 1];
            }
        }
        return dp[n - 1];
    }
}
