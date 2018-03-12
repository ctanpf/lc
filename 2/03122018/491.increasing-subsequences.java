/*
 * [491] Increasing Subsequences
 *
 * https://leetcode.com/problems/increasing-subsequences/description/
 *
 * algorithms
 * Medium (38.75%)
 * Total Accepted:    16.8K
 * Total Submissions: 43.4K
 * Testcase Example:  '[4,6,7,7]'
 *
 * 
 * Given an integer array, your task is to find all the different possible
 * increasing subsequences of the given array, and the length of an increasing
 * subsequence should be at least 2 .
 * 
 * 
 * Example:
 * 
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7],
 * [4,7,7]]
 * 
 * 
 * 
 * Note:
 * 
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also
 * be considered as a special case of increasing sequence.
 * 
 * 
 */
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        find(nums, new ArrayList<>(), res, 0);
        return res;
    }

    public void find(int[] nums, List<Integer> tmp, List<List<Integer>> res, int idx) {
        if (tmp.size() > 1) res.add(new ArrayList<>(tmp));
        HashSet<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            if (tmp.size() == 0 || tmp.get(tmp.size() - 1) <= nums[i]) {
                set.add(nums[i]);
                tmp.add(nums[i]);
                find(nums, tmp, res, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
