/*
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (47.28%)
 * Total Accepted:    230.7K
 * Total Submissions: 487.9K
 * Testcase Example:  '[1,2,3]'
 *
 * 
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * 
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * 
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return sol1(nums);
    }

    public List<List<Integer>> sol1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        recur(res, new ArrayList<>(), nums, 0, visited);
        return res;    
    }

    public void recur(List<List<Integer>> res, List<Integer> tmp, int[] nums, int index, boolean[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (index == nums.length) return;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(nums[i]);
                recur(res, tmp, nums, index + 1, visited);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
