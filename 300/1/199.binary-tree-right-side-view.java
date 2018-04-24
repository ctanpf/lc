/*
 * [199] Binary Tree Right Side View
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (42.56%)
 * Total Accepted:    107.8K
 * Total Submissions: 253.3K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example:
 * Given the following binary tree,
 * 
 * 
 * ⁠  1            <---
 * ⁠/   \
 * 2     3         <---
 * ⁠\     \
 * ⁠ 5     4       <---
 * 
 * 
 * 
 * 
 * You should return [1, 3, 4].
 * 
 * Credits:
 * Special thanks to @amrsaqr for adding this problem and creating all test
 * cases.
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
    int curDepth = 0;
    public List<Integer> rightSideView(TreeNode root) {
        // return sol(root);
        return sol2(root);
    }

    public List<Integer> sol(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) res.add(node.val);
                if (node.right != null) q.offer(node.right);
                if (node.left != null) q.offer(node.left);
            }
        }
        return res;
    }

    public List<Integer> sol2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        bt(root, 1, res);
        return res;
    }

    public void bt(TreeNode root, int d, List<Integer> res) {
        if (root == null) return;
        if (d > curDepth) {
            curDepth = d;  
            res.add(root.val);
        }
        bt(root.right, d + 1, res);
        bt(root.left, d + 1, res);
    }
}
