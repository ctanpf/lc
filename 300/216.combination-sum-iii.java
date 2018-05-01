/*
 * [216] Combination Sum III
 *
 * https://leetcode.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (47.34%)
 * Total Accepted:    89K
 * Total Submissions: 187.9K
 * Testcase Example:  '3\n7'
 *
 * 
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * 
 * 
 * ⁠Example 1:
 * Input:  k = 3,  n = 7
 * Output: 
 * 
 * [[1,2,4]]
 * 
 * 
 * ⁠Example 2:
 * Input:  k = 3,  n = 9
 * Output: 
 * 
 * [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 * 
 * Credits:Special thanks to @mithmatt for adding this problem and creating all
 * test cases.
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        bt(res, new ArrayList<>(), k, n, 1);
        return res;       
    }

    public void bt(List<List<Integer>> res, List<Integer> tmp, int k, int n, int idx) {
        if (tmp.size() == k && n != 0) return;
        if (tmp.size() == k && n == 0) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = idx; i <= 9; i++) {
            tmp.add(i);
            n -= i;
            bt(res, tmp, k, n, i + 1);
            n += i;
            tmp.remove(tmp.size() - 1);
        }
    }
}
