/*
 * [81] Search in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Medium (32.69%)
 * Total Accepted:    118.3K
 * Total Submissions: 361.9K
 * Testcase Example:  '[]\n5'
 *
 * 
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * The array may contain duplicates.
 */
class Solution {
    public boolean search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i)/2;
            if (nums[mid] == target) return true;
            if (nums[i] == nums[mid] && nums[j] == nums[mid]) {
                i++;
                j--;
            }
            else if (nums[mid] < nums[i]) {
                if (target > nums[mid] && target <= nums[j]) i = mid + 1;
                else j = mid - 1;
            }
            else {
                if (target < nums[mid] && target >= nums[i]) j = mid - 1;
                else i = mid + 1;
            }
        }
        return false;
    }
}
