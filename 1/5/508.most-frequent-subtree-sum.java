/*
 * [508] Most Frequent Subtree Sum
 *
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 *
 * algorithms
 * Medium (52.31%)
 * Total Accepted:    28K
 * Total Submissions: 53.5K
 * Testcase Example:  '[5,2,-3]'
 *
 * 
 * Given the root of a tree, you are asked to find the most frequent subtree
 * sum. The subtree sum of a node is defined as the sum of all the node values
 * formed by the subtree rooted at that node (including the node itself). So
 * what is the most frequent subtree sum value? If there is a tie, return all
 * the values with the highest frequency in any order.
 * 
 * 
 * Examples 1
 * Input:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -3
 * 
 * return [2, -3, 4], since all the values happen only once, return all of them
 * in any order.
 * 
 * 
 * Examples 2
 * Input:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -5
 * 
 * return [2], since 2 happens twice, however -5 only occur once.
 * 
 * 
 * Note:
 * You may assume the sum of values in any subtree is in the range of 32-bit
 * signed integer.
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        int[] max = {0};
        HashMap<Integer, Integer> map = new HashMap<>();
        find(root, max, map);
        List<Integer> tmp = new ArrayList<>();
        for (Integer i : map.keySet()) {
            if (map.get(i) == max[0]) tmp.add(i);
        }
        int[] res = new int[tmp.size()];
        for (int i = 0; i < res.length; i++) res[i] = tmp.get(i);
        return res;
    }

    public int find(TreeNode root, int[] max, HashMap<Integer, Integer> map) {
        if (root == null) return 0;
        int left = find(root.left, max, map);
        int right = find(root.right, max, map);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max[0] = Math.max(max[0], map.get(sum));
        return sum;
    }
}
