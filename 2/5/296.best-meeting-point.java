/*
 * [296] Best Meeting Point
 *
 * https://leetcode.com/problems/best-meeting-point/description/
 *
 * algorithms
 * Hard (52.35%)
 * Total Accepted:    16.3K
 * Total Submissions: 31.2K
 * Testcase Example:  '[[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]'
 *
 * A group of two or more people wants to meet and minimize the total travel
 * distance. You are given a 2D grid of values 0 or 1, where each 1 marks the
 * home of someone in the group. The distance is calculated using Manhattan
 * Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * 
 * For example, given three people living at (0,0), (0,4), and (2,2):
 * 
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * 
 * The point (0,2) is an ideal meeting point, as the total travel distance of
 * 2+2+2=6 is minimal. So return 6.
 */
class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        return getDist(row) + getDist(col);
    }

    public int getDist(List<Integer> arr) {
        Collections.sort(arr);
        int i = 0;
        int j = arr.size() - 1;
        int res = 0;
        while (i < j) {
            res += arr.get(j--) - arr.get(i++);
        }
        return res;
    }
}
