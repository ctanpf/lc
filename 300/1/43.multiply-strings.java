/*
 * [43] Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (28.01%)
 * Total Accepted:    135.6K
 * Total Submissions: 484.1K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) return "0";
        int[] val = new int[num1.length() + num2.length()];
        
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mux = (int)(num1.charAt(i) - '0') * (int)(num2.charAt(j) - '0');
                int p1 = i + j + 1;
                int p2 = i + j;
                mux += val[p1];
                val[p1] = mux%10;
                val[p2] += mux/10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : val) {
            if (!(i == 0 && sb.length() == 0)) sb.append(i);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
