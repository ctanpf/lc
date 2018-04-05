/*
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (25.27%)
 * Total Accepted:    304.2K
 * Total Submissions: 1.2M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example:
 * 
 * 
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "cbbd"
 * 
 * Output: "bb"
 * 
 * 
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        if (s == null || s.length() < 2) return s;
        for (int i = 0; i < s.length(); i++) {
            String a = getPld(s, i, i);
            String b = getPld(s, i, i + 1);
            if (a.length() > b.length() && a.length() > res.length()) res = a;
            else if (b.length() > a.length() && b.length() > res.length()) res = b;
        }
        return res;
    }

    public String getPld(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
