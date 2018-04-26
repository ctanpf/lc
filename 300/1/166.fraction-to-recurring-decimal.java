/*
 * [166] Fraction to Recurring Decimal
 *
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 *
 * algorithms
 * Medium (18.12%)
 * Total Accepted:    64.1K
 * Total Submissions: 353.5K
 * Testcase Example:  '1\n2'
 *
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * For example,
 * 
 * 
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 * 
 * 
 * 
 * Credits:
 * Special thanks to @Shangrila for adding this problem and creating all test
 * cases.
 * 
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if (numerator == 0) return "0";
        sb.append((numerator >= 0) ^ (denominator >= 0) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append((long)num/den);
        if (num%den == 0) return sb.toString();
        sb.append(".");
        num %= den;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while (num != 0) {
            num *= 10;
            sb.append(num/den);
            num %= den;
            if (!map.containsKey(num)) map.put(num, sb.length());
            else {
                int idx = map.get(num);
                sb.insert(idx, "(");
                sb.append(")");
                break;
            }
        }
        return sb.toString();
    }
}
