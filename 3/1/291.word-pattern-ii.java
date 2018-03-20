/*
 * [291] Word Pattern II
 *
 * https://leetcode.com/problems/word-pattern-ii/description/
 *
 * algorithms
 * Hard (38.50%)
 * Total Accepted:    21.5K
 * Total Submissions: 56K
 * Testcase Example:  '"abab"\n"redblueredblue"'
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 * ⁠Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty substring in str.
 * 
 * Examples:
 * 
 * pattern = "abab", str = "redblueredblue" should return true.
 * pattern = "aaaa", str = "asdasdasdasd" should return true.
 * pattern = "aabb", str = "xyzabcxzyabc" should return false.
 * 
 * 
 * 
 * 
 * Notes:
 * You may assume both pattern and str contains only lowercase letters.
 * 
 */
class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        return check(pattern, 0, str, 0, new HashMap<>(), new HashSet<>());
    }

    public boolean check(String pattern, int p, String str, int s, HashMap<Character, String> map, HashSet<String> set) {
        if (p == pattern.length() && s == str.length()) return true;
        if (p == pattern.length() || s == str.length()) return false;

        char c = pattern.charAt(p);

        if (map.containsKey(c)) {
            String val = map.get(c);
            if (!str.startsWith(val, s)) return false;
            return check(pattern, p + 1, str, s + val.length(), map, set);
        }

        for (int i = s; i < str.length(); i++) {
            String t = str.substring(s, i + 1);
            if (set.contains(t)) continue;
            set.add(t);
            map.put(c, t);
            if (check(pattern, p + 1, str, i + 1, map, set)) return true;
            set.remove(t);
            map.remove(c);
        }
        return false;
    }
}
