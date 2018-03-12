/*
 * [648] Replace Words
 *
 * https://leetcode.com/problems/replace-words/description/
 *
 * algorithms
 * Medium (47.68%)
 * Total Accepted:    14.2K
 * Total Submissions: 29.9K
 * Testcase Example:  '["cat", "bat", "rat"]\n"the cattle was rattled by the battery"'
 *
 * 
 * In English, we have a concept called root, which can be followed by some
 * other words to form another longer word - let's call this word successor.
 * For example, the root an, followed by other, which can form another word
 * another.
 * 
 * 
 * 
 * 
 * Now, given a dictionary consisting of many roots and a sentence. You need to
 * replace all the successor in the sentence with the root forming it. If a
 * successor has many roots can form it, replace it with the root with the
 * shortest length.
 * 
 * 
 * 
 * You need to output the sentence after the replacement.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The input will only have lower-case letters.
 * ⁠1 
 * ⁠1 
 * ⁠1 
 * ⁠1 
 * 
 * 
 */
class Solution {
    class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children;

        public TrieNode(char val) {
            this.val = val;
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }

    public TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode( ' ');
        for (String s : dict) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode(c);
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }
        return root;
    }

    public String getShortestString(TrieNode root, String s) {
        TrieNode cur = root;
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (cur.children[c - 'a'] != null) {
                res.append(c);
                if (cur.children[c - 'a'].isWord) return res.toString();
                else cur = cur.children[c - 'a'];
            }
            else return s;
        }
        return s;
    }
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = buildTrie(dict);
        String[] tokens = sentence.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = getShortestString(root, tokens[i]);
        }
        return String.join(" ", tokens);
    }
}
