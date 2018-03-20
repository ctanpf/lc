/*
 * [340] Longest Substring with At Most K Distinct Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
 *
 * algorithms
 * Hard (38.80%)
 * Total Accepted:    36.4K
 * Total Submissions: 93.8K
 * Testcase Example:  '"eceba"\n2'
 *
 * 
 * Given a string, find the length of the longest substring T that contains at
 * most k distinct characters.
 * 
 * 
 * 
 * For example,
 * 
 * Given s = “eceba” and k = 2,
 * 
 * 
 * 
 * T is "ece" which its length is 3.
 * 
 */
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int i = 0;
        int j = 0;
        int[] map = new int[256];
        int size = 0;
        int res = 0;
        for (j = 0; j < s.length(); j++) {
            if (map[s.charAt(j)]++ == 0) size++;
            while (size > k) {
                if (--map[s.charAt(i++)] == 0) size--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
