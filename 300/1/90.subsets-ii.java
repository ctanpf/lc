/*
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (38.29%)
 * Total Accepted:    144K
 * Total Submissions: 376K
 * Testcase Example:  '[1,2,2]'
 *
 * 
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * 
 * For example,
 * If nums = [1,2,2], a solution is:
 * 
 * 
 * 
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return sol(nums);
        // return sol2(nums);
    }

    public List<List<Integer>> sol(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        recur(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void recur(List<List<Integer>> res, List<Integer> tmp, int[] nums, int index) {
        res.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            tmp.add(nums[i]);
            recur(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
