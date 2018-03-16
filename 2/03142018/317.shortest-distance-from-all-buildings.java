/*
 * [317] Shortest Distance from All Buildings
 *
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/description/
 *
 * algorithms
 * Hard (34.77%)
 * Total Accepted:    22.6K
 * Total Submissions: 64.9K
 * Testcase Example:  '[[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]'
 *
 * You want to build a house on an empty land which reaches all buildings in
 * the shortest amount of distance. You can only move up, down, left and right.
 * You are given a 2D grid of values 0, 1 or 2, where:
 * 
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * 
 * 
 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle
 * at (0,2):
 * 
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * 
 * The point (1,2) is an ideal empty land to build a house, as the total travel
 * distance of 3+3+1=7 is minimal. So return 7.
 * 
 * Note:
 * There will be at least one building. If it is not possible to build such
 * house according to the above rules, return -1.
 */
class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] distance = new int[m][n];
        int[][] reach = new int[m][n];
        int building = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    building++;
                    bfs(grid, distance, reach, i, j);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && distance[i][j] != 0 && reach[i][j] == building) {
                    res = Math.min(res, distance[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void bfs(int[][] grid, int[][] distance, int[][] reach, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int lvl = 1;
        
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int size = q.size();
            for (int idx = 0; idx < size; idx++) {
                int[] cur = q.poll();
                for (int[] d : dirs) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 0) {
                        distance[x][y] += lvl;
                        reach[x][y]++;
                        visited[x][y] = true;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            lvl++;
        }
    }
}
