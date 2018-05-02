/*
 * [222] Count Complete Tree Nodes
 *
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Medium (27.73%)
 * Total Accepted:    77.9K
 * Total Submissions: 280.8K
 * Testcase Example:  '[]'
 *
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as
 * possible. It can have between 1 and 2h nodes inclusive at the last level h.
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
    public int countNodes(TreeNode root) {
        int l = 0;
        int r = 0;
        TreeNode left = root;
        TreeNode right = root;
        while (left != null) {
            left = left.left;
            l++;
        }
        while (right != null) {
            right = right.right;
            r++;
        }
        if (l == r) return (1 << l) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
