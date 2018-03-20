/*
 * [370] Range Addition
 *
 * https://leetcode.com/problems/range-addition/description/
 *
 * algorithms
 * Medium (57.07%)
 * Total Accepted:    16.5K
 * Total Submissions: 29K
 * Testcase Example:  '5\n[[1,3,2],[2,4,3],[0,2,-2]]'
 *
 * Assume you have an array of length n initialized with all 0's and are given
 * k update operations.
 * 
 * Each operation is represented as a triplet: [startIndex, endIndex, inc]
 * which increments each element of subarray A[startIndex ... endIndex]
 * (startIndex and endIndex inclusive) with inc.
 * 
 * Return the modified array after all k operations were executed.
 * 
 * Example:
 * 
 * Given:
 * 
 * ⁠   length = 5,
 * ⁠   updates = [
 * ⁠       [1,  3,  2],
 * ⁠       [2,  4,  3],
 * ⁠       [0,  2, -2]
 * ⁠   ]
 * 
 * Output:
 * 
 * ⁠   [-2, 0, 3, 5, 3]
 * 
 * 
 * 
 * Explanation:
 * 
 * Initial state:
 * [ 0, 0, 0, 0, 0 ]
 * 
 * After applying operation [1, 3, 2]:
 * [ 0, 2, 2, 2, 0 ]
 * 
 * After applying operation [2, 4, 3]:
 * [ 0, 2, 5, 5, 3 ]
 * 
 * After applying operation [0, 2, -2]:
 * [-2, 0, 3, 5, 3 ]
 * 
 * 
 * 
 * Credits:Special thanks to @vinod23 for adding this problem and creating all
 * test cases.
 */
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        int[] map = new int[length + 1];
        for (int[] u : updates) {
            map[u[0]] += u[2];
            map[u[1] + 1] -= u[2];
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += map[i];
            res[i] = sum;
        }
        return res;
    }
}
