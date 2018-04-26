/*
 * [163] Missing Ranges
 *
 * https://leetcode.com/problems/missing-ranges/description/
 *
 * algorithms
 * Medium (23.12%)
 * Total Accepted:    38.6K
 * Total Submissions: 167K
 * Testcase Example:  '[0,1,3,50,75]\n0\n99'
 *
 * 
 * Given a sorted integer array where the range of elements are in the
 * inclusive range [lower, upper], return its missing ranges.
 * 
 * 
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2",
 * "4->49", "51->74", "76->99"].
 * 
 */
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (lower == nums[j]) {
                if (nums[j] == Integer.MAX_VALUE) return res;
                lower++;
            }
            else if (lower < nums[j]){
                res.add(rangeStr(lower, nums[j] - 1));
                if (nums[j] == Integer.MAX_VALUE) return res;
                lower = nums[j] + 1;
            }
        }
        if (lower <= upper) res.add(rangeStr(lower, upper));
        return res;
    }

    public String rangeStr(int i, int j) {
        return i == j ? String.valueOf(i) : String.format("%s->%s", i, j);
    }
}
