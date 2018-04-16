/*
 * [129] Sum Root to Leaf Numbers
 *
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 *
 * algorithms
 * Medium (37.83%)
 * Total Accepted:    134.8K
 * Total Submissions: 356.4K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number
 * 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * 
 * 
 * 
 * 
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        check(root, 0);
        return sum;
    }

    public void check(TreeNode root, int val) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            val = 10 * val + root.val;
            sum += val;
            return;
        }
        check(root.left, 10 * val + root.val);
        check(root.right, 10 * val + root.val);
    }
}
