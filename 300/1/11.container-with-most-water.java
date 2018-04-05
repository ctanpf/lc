/*
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (37.11%)
 * Total Accepted:    192.5K
 * Total Submissions: 518.8K
 * Testcase Example:  '[1,1]'
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 */
class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        if (height == null || height.length == 0) return res;
        int i = 0;
        int j = height.length - 1;
        int left = 0;
        int right = 0;
        while (i < j) {
            left = Math.max(left, height[i]);
            right = Math.max(right, height[j]);
            res = Math.max(res, Math.min(left, right) * (j - i));
            if (left < right) i++;
            else j--;
        }
        return res;
    }
}
