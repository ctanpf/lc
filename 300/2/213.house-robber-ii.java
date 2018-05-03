/*
 * [213] House Robber II
 *
 * https://leetcode.com/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (34.64%)
 * Total Accepted:    76.4K
 * Total Submissions: 220.6K
 * Testcase Example:  '[]'
 *
 * Note: This is an extension of House Robber.
 * 
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This
 * time, all houses at this place are arranged in a circle. That means the
 * first house is the neighbor of the last one. Meanwhile, the security system
 * for these houses remain the same as for those in the previous street. 
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * Credits:Special thanks to @Freezen for adding this problem and creating all
 * test cases.
 */
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int a = rob(nums, 0, nums.length - 2);
        int b = rob(nums, 1, nums.length - 1);
        return Math.max(a, b);        
    }

    public int rob(int[] nums, int i, int j) {
        int odd = 0;
        int even = 0;
        for (i = i; i <= j; i++) {
            if (i%2 == 0) even = Math.max(even + nums[i], odd);
            else odd = Math.max(odd + nums[i], even);
        }
        return Math.max(odd, even);
    }
}
