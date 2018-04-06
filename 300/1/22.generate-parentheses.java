/*
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (47.97%)
 * Total Accepted:    204.5K
 * Total Submissions: 426.2K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        genParenthesis(res, "", 0, 0, n);
        return res;
    }

    public void genParenthesis(List<String> res, String tmp, int left, int right, int n) {
        if (tmp.length() == 2 * n) {
            res.add(tmp);
            return;
        }
        if (left < n) genParenthesis(res, tmp + "(", left + 1, right, n);
        if (right < left) genParenthesis(res, tmp + ")", left, right + 1, n);
    }
}
