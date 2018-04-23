/*
 * [156] Binary Tree Upside Down
 *
 * https://leetcode.com/problems/binary-tree-upside-down/description/
 *
 * algorithms
 * Medium (45.96%)
 * Total Accepted:    34.7K
 * Total Submissions: 75.6K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given a binary tree where all the right nodes are either leaf nodes with a
 * sibling (a left node that shares the same parent node) or empty, flip it
 * upside down and turn it into a tree where the original right nodes turned
 * into left leaf nodes. Return the new root.
 * 
 * For example:
 * Given a binary tree {1,2,3,4,5},
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠/ \
 * 4   5
 * 
 * 
 * 
 * 
 * return the root of the binary tree [4,5,2,#,#,3,1].
 * 
 * 
 * ⁠  4
 * ⁠ / \
 * ⁠5   2
 * ⁠   / \
 * ⁠  3   1  
 * 
 * 
 * 
 * 
 * confused what "{1,#,2,3}" means? > read more on how binary tree is
 * serialized on OJ.
 * 
 * 
 * OJ's Binary Tree Serialization:
 * 
 * The serialization of a binary tree follows a level order traversal, where
 * '#' signifies a path terminator where no node exists below.
 * 
 * Here's an example:
 * 
 * 
 * ⁠  1
 * ⁠ / \
 * ⁠2   3
 * ⁠   /
 * ⁠  4
 * ⁠   \
 * ⁠    5
 * 
 * 
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 * 
 * 
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        TreeNode node = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return node;
    }
}
