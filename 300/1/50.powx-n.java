/*
 * [50] Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (26.03%)
 * Total Accepted:    207.5K
 * Total Submissions: 797K
 * Testcase Example:  '2.00000\n10'
 *
 * Implement pow(x, n).
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 2.00000, 10
 * Output: 1024.00000
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 2.10000, 3
 * Output: 9.26100
 * 
 * 
 */
class Solution {
    public double myPow(double x, int n) {
        if (n < 0) return 1/Pow(x, n);
        return Pow(x, n);
    }

    public double Pow(double x, int n) {
        if (n == 0) return 1;
        double val = Pow(x, n/2);
        if (n%2 == 0) return val * val;
        else return val * val * x;
    }
}
