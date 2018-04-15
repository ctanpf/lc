/*
 * [71] Simplify Path
 *
 * https://leetcode.com/problems/simplify-path/description/
 *
 * algorithms
 * Medium (26.32%)
 * Total Accepted:    111.7K
 * Total Submissions: 424.3K
 * Testcase Example:  '"/home/"'
 *
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * click to show corner cases.
 * 
 * Corner Cases:
 * 
 * 
 * 
 * 
 * 
 * 
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together,
 * such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * 
 */
class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return "";
        Stack<String> st = new Stack<>();
        for (int j = 0; j < path.length(); j++) {
            char c = path.charAt(j);
            if (c != '/') {
                int i = j;
                while (j < path.length() && path.charAt(j) != '/') j++;
                String d = path.substring(i, j);
                if (d.equals("..") && !st.isEmpty()) st.pop();
                else if (d.equals(".") || d.equals("..")) continue;
                else st.push(d);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.insert(0, "/" + st.pop());
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
