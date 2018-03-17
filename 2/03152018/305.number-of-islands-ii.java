/*
 * [305] Number of Islands II
 *
 * https://leetcode.com/problems/number-of-islands-ii/description/
 *
 * algorithms
 * Hard (39.62%)
 * Total Accepted:    31.4K
 * Total Submissions: 79.4K
 * Testcase Example:  '3\n3\n[[0,0],[0,1],[1,2],[2,1]]'
 *
 * A 2d grid map of m rows and n columns is initially filled with water.
 * We may perform an addLand operation which turns the water at position (row,
 * col) into a land.
 * Given a list of positions to operate, count the number of islands after each
 * addLand operation.
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example:
 * Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water
 * and 1 represents land).
 * 
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * 
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * 
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * 
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * 
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * 
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * 
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 * 
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * 
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 * 
 * We return the result as an array: [1, 1, 2, 3]
 * 
 * Challenge:
 * Can you do it in time complexity O(k log mn), where k is the length of the
 * positions?
 */
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions == null || positions.length == 0) return res;
        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] p : positions) {
            int root = n * p[0] + p[1];
            roots[root] = root;
            count++;

            for (int[] d : dirs) {
                int x = p[0] + d[0];
                int y = p[1] + d[1];
                int newRoot = n * x + y;
                if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || roots[newRoot] == -1) continue;
                int rootNb = findRoot(roots, newRoot);
                if (root != rootNb) {
                    roots[root] = rootNb;
                    root = rootNb;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }

    public int findRoot(int[] roots, int id) {
        while (id != roots[id]) id = roots[id];
        return id;
    }
}
