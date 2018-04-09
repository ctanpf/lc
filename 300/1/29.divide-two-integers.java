/*
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (15.73%)
 * Total Accepted:    130.2K
 * Total Submissions: 827.5K
 * Testcase Example:  '0\n1'
 *
 * 
 * Divide two integers without using multiplication, division and mod
 * operator.
 * 
 * 
 * If it is overflow, return MAX_INT.
 * 
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == dividend) return 1;
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;

        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        int res = 0;

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        while (dvs <= dvd) {
            int tmp = 1;
            long mux = dvs;
            while ((mux << 1) < dvd) {
                mux <<= 1;
                tmp <<= 1;
            }
            res += tmp;
            dvd -= mux;
        }
        return res * sign;
    }
}
