/*
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (41.34%)
 * Total Accepted:    142.5K
 * Total Submissions: 344.8K
 * Testcase Example:  '4\n2'
 *
 * 
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:
 * 
 * 
 * 
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        check(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    public void check(List<List<Integer>> res, List<Integer> tmp, int idx, int n, int k) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i <= n; i++) {
            tmp.add(i);
            check(res, tmp, i + 1, n, k);
            tmp.remove(tmp.size() - 1);
        }
    }
}
