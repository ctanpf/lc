/*
 * [384] Shuffle an Array
 *
 * https://leetcode.com/problems/shuffle-an-array/description/
 *
 * algorithms
 * Medium (47.30%)
 * Total Accepted:    39.9K
 * Total Submissions: 84.3K
 * Testcase Example:  '["Solution","shuffle","reset","shuffle"]\n[[[1,2,3]],[],[],[]]'
 *
 * Shuffle a set of numbers without duplicates.
 * 
 * 
 * Example:
 * 
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * 
 * // Shuffle the array [1,2,3] and return its result. Any permutation of
 * [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * 
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * 
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 * 
 * 
 */
class Solution {
    int[] nums;
    int[] copy;
    Random random;
    public Solution(int[] nums) {
        random = new Random();
        this.nums = nums;
        copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = copy.length;
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(n - i);
            int tmp = copy[index];
            copy[index] = copy[i + index];
            copy[i + index] = tmp;
        }
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
