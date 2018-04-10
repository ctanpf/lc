/*
 * [34] Search for a Range
 *
 * https://leetcode.com/problems/search-for-a-range/description/
 *
 * algorithms
 * Medium (31.59%)
 * Total Accepted:    186K
 * Total Submissions: 588.8K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers sorted in ascending order, find the starting and
 * ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i)/2;
            if (target > nums[mid]) i = mid + 1;
            else j = mid;
        }
        if (nums[j] != target) return res;
        res[0] = j;
        i = j;
        j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i)/2 + 1;
            if (target < nums[mid]) j = mid - 1;
            else i = mid;
        }
        res[1] = j;
        return res;
    }
}
