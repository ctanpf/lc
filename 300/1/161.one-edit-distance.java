/*
 * [161] One Edit Distance
 *
 * https://leetcode.com/problems/one-edit-distance/description/
 *
 * algorithms
 * Medium (31.64%)
 * Total Accepted:    50.2K
 * Total Submissions: 158.6K
 * Testcase Example:  '""\n""'
 *
 * Given two strings S and T, determine if they are both one edit distance
 * apart.
 */
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) return s.substring(i + 1).equals(t.substring(i + 1));
                else if (s.length() > t.length()) return s.substring(i + 1).equals(t.substring(i));
                else return s.substring(i).equals(t.substring(i + 1));
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
