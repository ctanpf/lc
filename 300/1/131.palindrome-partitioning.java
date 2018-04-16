/*
 * [131] Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (35.72%)
 * Total Accepted:    119.3K
 * Total Submissions: 334K
 * Testcase Example:  '"aab"'
 *
 * 
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * 
 * For example, given s = "aab",
 * 
 * Return
 * 
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i <= 2) || (dp[i + 1][j - 1]))) {
                    dp[i][j] = true;
                }
            }
        }
        bt(res, new ArrayList<>(), s, 0, dp);
        return res;
    }

    public void bt(List<List<String>> res, List<String> tmp, String s, int idx, boolean[][] dp) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (dp[idx][i]) {
                tmp.add(s.substring(idx, i + 1));
                bt(res, tmp, s, i + 1, dp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
