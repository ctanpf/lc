/*
 * [473] Matchsticks to Square
 *
 * https://leetcode.com/problems/matchsticks-to-square/description/
 *
 * algorithms
 * Medium (35.39%)
 * Total Accepted:    14.8K
 * Total Submissions: 41.7K
 * Testcase Example:  '[1,1,2,2,2]'
 *
 * Remember the story of Little Match Girl? By now, you know exactly what
 * matchsticks the little match girl has, please find out a way you can make
 * one square by using up all those matchsticks. You should not break any
 * stick, but you can link them up, and each matchstick must be used exactly
 * one time.
 * 
 * ⁠Your input will be several matchsticks the girl has, represented with their
 * stick length. Your output will either be true or false, to represent whether
 * you could make one square using all the matchsticks the little match girl
 * has.
 * 
 * Example 1:
 * 
 * Input: [1,1,2,2,2]
 * Output: true
 * 
 * Explanation: You can form a square with length 2, one side of the square
 * came two sticks with length 1.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [3,3,3,3,4]
 * Output: false
 * 
 * Explanation: You cannot find a way to form a square with all the
 * matchsticks.
 * 
 * 
 * 
 * Note:
 * 
 * The length sum of the given matchsticks is in the range of 0 to 10^9.
 * The length of the given matchstick array will not exceed 15.
 * 
 * 
 */
class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 4 != 0) return false;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
        return check(nums, new int[4], 0, sum/4);
    }

    public boolean check(int[] nums, int[] arr, int idx, int target) {
        if (idx == nums.length) {
            if (arr[0] == target && arr[1] == target && arr[2] == target && arr[3] == target) return true;
            else return false;
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i] + nums[idx] > target) continue;
            arr[i] += nums[idx];
            if (check(nums, arr, idx + 1, target)) return true;
            arr[i] -= nums[idx];
        }
        return false;
    }
}
