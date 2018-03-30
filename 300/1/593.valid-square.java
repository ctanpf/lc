/*
 * [593] Valid Square
 *
 * https://leetcode.com/problems/valid-square/description/
 *
 * algorithms
 * Medium (39.80%)
 * Total Accepted:    10.7K
 * Total Submissions: 27K
 * Testcase Example:  '[0,0]\n[1,1]\n[1,0]\n[0,1]'
 *
 * Given the coordinates of four points in 2D space, return whether the four
 * points could construct a square.
 * 
 * The coordinate (x,y) of a point is represented by an integer array with two
 * integers.
 * 
 * Example:
 * 
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 * 
 * 
 * 
 * ⁠Note: 
 * 
 * All the input integers are in the range [-10000, 10000].
 * A valid square has four equal sides with positive length and four equal
 * angles (90-degree angles).
 * Input points have no order.
 * 
 * 
 */
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] sides = 
        {
            getDist(p1, p2), 
            getDist(p2, p3),
            getDist(p3, p4),
            getDist(p4, p1),
            getDist(p1, p3),
            getDist(p4, p2),
        };

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int s : sides) {
            max = Math.max(s, max);
            min = Math.min(s, min);
        }
        int longest = 0;
        int shortest = 0;
        for (int s : sides) {
            if (s == max) longest++;
            if (s == min) shortest++;
        }
        if (longest != 2) return false;
        if (shortest != 4) return false;
        return true;
    }

    public int getDist(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
