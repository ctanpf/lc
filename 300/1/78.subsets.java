/*
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (44.74%)
 * Total Accepted:    229.7K
 * Total Submissions: 513.4K
 * Testcase Example:  '[1,2,3]'
 *
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * 
 * For example,
 * If nums = [1,2,3], a solution is:
 * 
 * 
 * 
 * [
 * ⁠ [3],
 * ⁠ [1],
 * ⁠ [2],
 * ⁠ [1,2,3],
 * ⁠ [1,3],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // return sol(nums);
        return sol2(nums);
    }

    public List<List<Integer>> sol(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recur(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void recur(List<List<Integer>> res, List<Integer> tmp, int[] nums, int index) {
        res.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            recur(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> sol2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i : nums) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(i);
                res.add(new ArrayList<>(tmp));
            }
        }
        return res;
    }
}
