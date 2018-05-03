/*
 * [227] Basic Calculator II
 *
 * https://leetcode.com/problems/basic-calculator-ii/description/
 *
 * algorithms
 * Medium (30.19%)
 * Total Accepted:    65.5K
 * Total Submissions: 217.1K
 * Testcase Example:  '"3+2*2"'
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces  . The integer division should truncate toward
 * zero.
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * 
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * 
 * 
 * 
 * 
 * Note: Do not use the eval built-in library function.
 * 
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test
 * cases.
 */
class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        char op = '+';
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') res = 10 * res + (int)(c - '0');
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                if (op == '+') st.push(+res);
                else if (op == '-') st.push(-res);
                else if (op == '/') st.push(st.pop() / res);
                else if (op == '*') st.push(st.pop() * res);
                op = c;
                res = 0;
            }
        }
        while (!st.isEmpty()) res += st.pop();
        return res;
    }
}
