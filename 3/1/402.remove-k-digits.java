/*
 * [402] Remove K Digits
 *
 * https://leetcode.com/problems/remove-k-digits/description/
 *
 * algorithms
 * Medium (25.99%)
 * Total Accepted:    29.5K
 * Total Submissions: 113.4K
 * Testcase Example:  '"1432219"\n3'
 *
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * 
 * Note:
 * 
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
 * which is the smallest.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the
 * output must not contain leading zeroes.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with
 * nothing which is 0.
 * 
 * 
 */
class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || k >= num.length() ) return "0";
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            while (i < num.length() && k > 0 && !st.isEmpty() && st.peek() > num.charAt(i)) {
                --k;
                st.pop();
            }
            st.push(num.charAt(i++));
        }

        while (k != 0) {
            st.pop();
            --k;
        }

        while (!st.isEmpty()) sb.append(st.pop());
        String tmp = sb.reverse().toString();
        i = 0;
        while (i < tmp.length() && tmp.charAt(i) == '0') i++;
        String res = tmp.substring(i);
        return res.length() == 0 ? "0" : res;
    }
}
