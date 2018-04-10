/*
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (41.39%)
 * Total Accepted:    214.3K
 * Total Submissions: 517.8K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * 
 * Given a set of candidate numbers (C) (without duplicates) and a target
 * number (T), find all unique combinations in C where the candidate numbers
 * sums to T. 
 * 
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * 
 * 
 * For example, given candidate set [2, 3, 6, 7] and target 7, 
 * A solution set is: 
 * 
 * [
 * ⁠ [7],
 * ⁠ [2, 2, 3]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        recur(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    public void recur(int[] candidates, int target, int index, List<Integer> tmp, List<List<Integer>> res) {
        if (index == candidates.length && target != 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) continue;
            tmp.add(candidates[i]);
            recur(candidates, target - candidates[i], i, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}
