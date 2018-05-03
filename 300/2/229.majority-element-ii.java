/*
 * [229] Majority Element II
 *
 * https://leetcode.com/problems/majority-element-ii/description/
 *
 * algorithms
 * Medium (29.24%)
 * Total Accepted:    70.9K
 * Total Submissions: 242.4K
 * Testcase Example:  '[]'
 *
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int v1 = nums[0];
        int v2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for (int i : nums) {
            if (i == v1) count1++;
            else if (i == v2) count2++;
            else if (count1 == 0) {
                count1 = 1;
                v1 = i;
            }
            else if (count2 == 0) {
                count2 = 1;
                v2 = i;
            }
            else {
                count1--;
                count2--;
            }
        }
        int a = 0;
        int b = 0;
        for (int i : nums) {
            if (i == v1) a++;
            else if (i == v2) b++;
        }
        if (a > nums.length/3) res.add(v1);
        if (b > nums.length/3) res.add(v2);
        return res;
    }
}
