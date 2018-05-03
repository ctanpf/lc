/*
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (49.68%)
 * Total Accepted:    104.3K
 * Total Submissions: 209.9K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * 
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * 
 * Note: 
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * 
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        List<Integer>[] count = new List[nums.length + 1];
        for (Integer key : map.keySet()) {
            if (count[map.get(key)] == null) count[map.get(key)] = new ArrayList<>();
            count[map.get(key)].add(key);
        }        
        for (int i = nums.length; i > 0 && k != 0; i--) {
            if (count[i] == null) continue;
            for (int j = 0; j < count[i].size() && k != 0; j++) {
                res.add(count[i].get(j));
                k--;
            }
        }
        return res;
    }
}
