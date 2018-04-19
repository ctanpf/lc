/*
 * [137] Single Number II
 *
 * https://leetcode.com/problems/single-number-ii/description/
 *
 * algorithms
 * Medium (42.69%)
 * Total Accepted:    133.8K
 * Total Submissions: 313.5K
 * Testcase Example:  '[1]'
 *
 * 
 * Given an array of integers, every element appears three times except for
 * one, which appears exactly once. Find that single one.
 * 
 * 
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 */
class Solution {
    public int singleNumber(int[] nums) {
        return sol(nums);
    }

    public int sol(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int num = 0;
            for (int j : nums) {
                num += (1 & (j >> i));
            }
            res |= (num%3) << i;
        }
        return res;
    }
}
