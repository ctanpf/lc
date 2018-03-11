/*
 * [498] Diagonal Traverse
 *
 * https://leetcode.com/problems/diagonal-traverse/description/
 *
 * algorithms
 * Medium (46.29%)
 * Total Accepted:    16.9K
 * Total Submissions: 36.4K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 
 * Given a matrix of M x N elements (M rows, N columns), return all elements of
 * the matrix in diagonal order as shown in the below image. 
 * 
 * 
 * Example:
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 * Explanation:
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The total number of elements of the given matrix will not exceed 10,000.
 * 
 * 
 */
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[]{};
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        int[] res = new int[m * n];
        int[][] dirs = {{-1, 1}, {1, -1}};
        boolean up = true;
        for (int i = 0; i < m * n ; i++) {
            res[i] = matrix[x][y];
            if (up) {
                x += dirs[0][0];
                y += dirs[0][1];
            }
            else {
                x += dirs[1][0];
                y += dirs[1][1];
            }

            if (x >= m) {
                y += 2;
                x = m - 1;
                up ^= true;
            }
            if (y >= n) {
                x += 2;
                y = n - 1;
                up ^= true;
            }
            if (x < 0) {
                x = 0;
                up ^= true;
            }
            if (y < 0) {
                y = 0;
                up ^= true;
            }
        }
        return res;
    }
}
