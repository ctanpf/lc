/*
 * [150] Evaluate Reverse Polish Notation
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 *
 * algorithms
 * Medium (28.50%)
 * Total Accepted:    114.7K
 * Total Submissions: 402.5K
 * Testcase Example:  '["2","1","+","3","*"]'
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples:
 * 
 * 
 * ⁠ ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ⁠ ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * 
 * 
 * 
 */
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> num = new Stack<>();
        for (String t : tokens) {
            char c = t.charAt(0);
            if ((t.length() == 1) && (c == '+' || c == '-' || c == '*' || c == '/')) {
                if (c == '+') {
                    num.push(num.pop() + num.pop());
                }
                else if (c == '-') {
                    int b = num.pop();
                    num.push(num.pop() - b);
                }
                else if (c == '*') {
                    num.push(num.pop() * num.pop());
                }
                else if (c == '/') {
                    int b = num.pop();
                    num.push(num.pop() / b);
                }
            }
            else num.push(Integer.parseInt(t));
        }
        return num.peek();
    }
}
