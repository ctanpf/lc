/*
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (35.07%)
 * Total Accepted:    160.4K
 * Total Submissions: 457.5K
 * Testcase Example:  '[1,1,2]'
 *
 * 
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * 
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * 
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // return sol(nums);
        return sol2(nums);
    }

    public List<List<Integer>> sol(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recur(res, new ArrayList<>(), nums, 0, new boolean[nums.length]);
        return res;
    }

    public void recur(List<List<Integer>> res, List<Integer> tmp, int[] nums, int index, boolean[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (index == nums.length) return;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i] && !set.contains(nums[i])) {
                set.add(nums[i]);
                visited[i] = true;
                tmp.add(nums[i]);
                recur(res, tmp, nums, index + 1, visited);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> sol2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        recur2(res, new ArrayList<>(), nums, 0, new boolean[nums.length]);
        return res;
    }

    public void recur2(List<List<Integer>> res, List<Integer> tmp, int[] nums, int index, boolean[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (index == nums.length) return;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;
            visited[i] = true;
            tmp.add(nums[i]);
            recur2(res, tmp, nums, index + 1, visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
}
