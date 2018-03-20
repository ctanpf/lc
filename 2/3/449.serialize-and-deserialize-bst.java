/*
 * [449] Serialize and Deserialize BST
 *
 * https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 *
 * algorithms
 * Medium (42.85%)
 * Total Accepted:    24.9K
 * Total Submissions: 58.1K
 * Testcase Example:  '[2,1,3]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment. 
 * 
 * Design an algorithm to serialize and deserialize a binary search tree. There
 * is no restriction on how your serialization/deserialization algorithm should
 * work. You just need to ensure that a binary search tree can be serialized to
 * a string and this string can be deserialized to the original tree
 * structure.
 * 
 * 
 * The encoded string should be as compact as possible.
 * 
 * 
 * 
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            sb.append(node.val);
            sb.append(',');
            if (node.right != null) st.push(node.right);
            if (node.left != null) st.push(node.left);
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        Queue<Integer> q = new LinkedList<>();
        for (String s : arr) {
            q.offer(Integer.parseInt(s));
        }
        return getTree(q);
    }

    public TreeNode getTree(Queue<Integer> q) {
        if (q.isEmpty()) return null;
        TreeNode node = new TreeNode(q.poll());
        Queue<Integer> smaller = new LinkedList<>();
        while (!q.isEmpty() && q.peek() < node.val) smaller.offer(q.poll());
        node.left = getTree(smaller);
        node.right = getTree(q);
        return node;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
