/*
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (42.06%)
 * Total Accepted:    50K
 * Total Submissions: 118.9K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * 
 * Given an encoded string, return it's decoded string.
 * 
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * 
 */
class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        Stack<Integer> intSt = new Stack<>();
        Stack<String> strSt = new Stack<>();
        String res = "";
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') count = 10 * count + (int)(c - '0');
            else if (c == '[') {
                strSt.push(res);
                res = "";
                intSt.push(count);
                count = 0;
            }
            else if (c == ']') {
                int val = intSt.pop();
                String tmp = strSt.pop();
                for (int j = 0; j < val; j++) tmp += res;
                res = tmp;
            }
            else res += c;
        }
        return res;
    }
}
