/*
 * [536] Construct Binary Tree from String
 *
 * https://leetcode.com/problems/construct-binary-tree-from-string/description/
 *
 * algorithms
 * Medium (42.62%)
 * Total Accepted:    10K
 * Total Submissions: 23.5K
 * Testcase Example:  '"4(2(3)(1))(6(5))"'
 *
 * You need to construct a binary tree from a string consisting of parenthesis
 * and integers. 
 * 
 * The whole input represents a binary tree. It contains an integer followed by
 * zero, one or two pairs of parenthesis. The integer represents the root's
 * value and a pair of parenthesis contains a child binary tree with the same
 * structure. 
 * 
 * You always start to construct the left child node of the parent first if it
 * exists.
 * 
 * Example:
 * 
 * Input: "4(2(3)(1))(6(5))"
 * Output: return the tree root node representing the following tree:
 * 
 * ⁠      4
 * ⁠    /   \
 * ⁠   2     6
 * ⁠  / \   / 
 * ⁠ 3   1 5   
 * 
 * 
 * 
 * Note:
 * 
 * There will only be '(',  ')',  '-' and  '0' ~ '9' in the input string.
 * An empty tree is represented by "" instead of "()".
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
    public TreeNode str2tree(String s) {
        if (s.length() == 0) return null;
        Stack<TreeNode> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') st.pop();
            if (c == '-' || c >= '0' && c <= '9') {
                int j = i;
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                TreeNode node = new TreeNode(Integer.parseInt(
                    s.substring(j, i + 1)
                ));
                if (!st.isEmpty()) {
                    if (st.peek().left == null) st.peek().left = node;
                    else st.peek().right = node;
                }
                st.push(node);
            }
        }
        return st.isEmpty() ? null : st.peek();
    }
}
