/*
 * [228] Summary Ranges
 *
 * https://leetcode.com/problems/summary-ranges/description/
 *
 * algorithms
 * Medium (32.25%)
 * Total Accepted:    99.1K
 * Total Submissions: 307.2K
 * Testcase Example:  '[0,1,2,4,5,7]'
 *
 * 
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * Example 1:
 * 
 * Input: [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * 
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            int i = j;
            while (j + 1 < nums.length && nums[j] + 1 == nums[j + 1]) {
                j++;
            }
            res.add(str(nums[i], nums[j]));
        }
        return res;
    }

    public String str(int a, int b) {
        return a == b ? String.valueOf(a) : String.format("%s->%s", a, b);
    }
}
