/*
 * [230] Kth Smallest Element in a BST
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * algorithms
 * Medium (45.39%)
 * Total Accepted:    141.3K
 * Total Submissions: 311.4K
 * Testcase Example:  '[1]\n1'
 *
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to
 * find the kth smallest frequently? How would you optimize the kthSmallest
 * routine?
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test
 * cases.
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
    public int kthSmallest(TreeNode root, int k) {
        // return sol(root, k);
        // return sol2(root, k);
        return sol3(root, k);
    }

    public int sol(TreeNode root, int k) {
        TreeNode cur = root;
        int res = 0;
        Stack<TreeNode> st = new Stack<>();
        while (cur != null) {
            st.push(cur);
            cur = cur.left;
        }

        while (!st.isEmpty() && k > 0) {
            --k;
            TreeNode node = st.pop();
            res = node.val;
            TreeNode tmp = node.right;
            while (tmp != null) {
                st.push(tmp);
                tmp = tmp.left;
            }
        }
        return res;
    }

    public int sol2(TreeNode root, int k) {
        return inorder(root, k);
    }

    public int inorder(TreeNode root, int k) {
        if (root == null) return -1;
        int val = inorder(root.left, k);
        if (k == 0) return val;
        if (--k == 0) return root.val;
        return inorder(root.right, k);
    }

    public int sol3(TreeNode root, int k) {
        int count = count(root.left);
        if (k <= count) return sol3(root.left, k);
        if (k > count + 1) return sol3(root.right, k - count - 1);
        return root.val;
    }

    public int count(TreeNode root) {
        if (root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }
}
