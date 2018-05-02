/*
 * [223] Rectangle Area
 *
 * https://leetcode.com/problems/rectangle-area/description/
 *
 * algorithms
 * Medium (33.84%)
 * Total Accepted:    71.6K
 * Total Submissions: 211.5K
 * Testcase Example:  '-3\n0\n3\n4\n0\n-1\n9\n2'
 *
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as
 * shown in the figure.
 * 
 * 
 * 
 * Assume that the total area is never beyond the maximum possible value of
 * int.
 * 
 * Credits:
 * Special thanks to @mithmatt for adding this problem, creating the above
 * image and all test cases.
 * 
 */
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a1 = Math.abs(C - A) * Math.abs(D - B);
        int a2 = Math.abs(G - E) * Math.abs(H - F);
        if (E >= C || F >= D || B >= H || A >= G) return a1 + a2;
        int a3 = (Math.min(C, G) - Math.max(E, A)) * (Math.min(D, H) - Math.max(F, B));
        return a1 + a2 - a3;
    }
}
