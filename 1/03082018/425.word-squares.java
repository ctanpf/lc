/*
 * [425] Word Squares
 *
 * https://leetcode.com/problems/word-squares/description/
 *
 * algorithms
 * Hard (43.11%)
 * Total Accepted:    13.8K
 * Total Submissions: 32K
 * Testcase Example:  '["area","lead","wall","lady","ball"]'
 *
 * Given a set of words (without duplicates), find all word squares you can
 * build from them.
 * 
 * A sequence of words forms a valid word square if the kth row and column read
 * the exact same string, where 0 ≤ k < max(numRows, numColumns).
 * 
 * For example, the word sequence ["ball","area","lead","lady"] forms a word
 * square because each word reads the same both horizontally and vertically.
 * 
 * 
 * b a l l
 * a r e a
 * l e a d
 * l a d y
 * 
 * 
 * Note:
 * 
 * There are at least 1 and at most 1000 words.
 * All words will have the exact same length.
 * Word length is at least 1 and at most 5.
 * Each word contains only lowercase English alphabet a-z.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * ["area","lead","wall","lady","ball"]
 * 
 * Output:
 * [
 * ⁠ [ "wall",
 * ⁠   "area",
 * ⁠   "lead",
 * ⁠   "lady"
 * ⁠ ],
 * ⁠ [ "ball",
 * ⁠   "area",
 * ⁠   "lead",
 * ⁠   "lady"
 * ⁠ ]
 * ]
 * 
 * Explanation:
 * The output consists of two word squares. The order of output does not matter
 * (just the order of words in each word square matters).
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * ["abat","baba","atan","atal"]
 * 
 * Output:
 * [
 * ⁠ [ "baba",
 * ⁠   "abat",
 * ⁠   "baba",
 * ⁠   "atan"
 * ⁠ ],
 * ⁠ [ "baba",
 * ⁠   "abat",
 * ⁠   "baba",
 * ⁠   "atal"
 * ⁠ ]
 * ]
 * 
 * Explanation:
 * The output consists of two word squares. The order of output does not matter
 * (just the order of words in each word square matters).
 * 
 * 
 */
class Solution {
    class TrieNode {
        TrieNode[] children;
        List<String> startsWith;
        
        public TrieNode() {
            this.children = new TrieNode[26];
            this.startsWith = new ArrayList<>();
        }
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode cur = root;
            for (char c : w.toCharArray()) {
                if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
                cur.children[c - 'a'].startsWith.add(w);
                cur = cur.children[c - 'a'];
            }
        }
        return root;
    }

    public List<String> findPrefixs(String s, TrieNode root) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.children[c - 'a'] == null) return new ArrayList<>();
            cur = cur.children[c - 'a'];
        }
        return cur.startsWith;
    }
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        List<String> tmp = new ArrayList<>();
        int len = words[0].length();
        for (String s : words) {
            tmp.add(s);
            find(len, tmp, res, root);
            tmp.remove(tmp.size() - 1);
        }
        return res;
    }

    public void find(int len, List<String> tmp, List<List<String>> res, TrieNode root) {
        if (tmp.size() == len) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        StringBuilder prefix = new StringBuilder();
        int idx = tmp.size();
        for (String s : tmp) prefix.append(s.charAt(idx));
        List<String> prefixs = findPrefixs(prefix.toString(), root);
        for (String s : prefixs) {
            tmp.add(s);
            find(len, tmp, res, root);
            tmp.remove(tmp.size() - 1);
        }
    }
}
