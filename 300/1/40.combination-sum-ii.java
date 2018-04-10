/*
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (35.94%)
 * Total Accepted:    149.2K
 * Total Submissions: 415K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * 
 * Given a collection of candidate numbers (C) and a target number (T), find
 * all unique combinations in C where the candidate numbers sums to T.
 * 
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * 
 * 
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
 * A solution set is: 
 * 
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > index && candidates[i] != candidates[i - 1]) {
                tmp.add(candidates[i]);
                recur(candidates, target - candidates[i], i + 1, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
