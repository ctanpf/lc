/*
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (20.07%)
 * Total Accepted:    161.8K
 * Total Submissions: 806.3K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * 
 * For example,
 * 
 * 
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * 
 * Note:
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * 
 * 
 * UPDATE (2017/1/20):
 * The wordList parameter had been changed to a list of strings (instead of a
 * set of strings). Please reload the code definition to get the latest
 * changes.
 * 
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // return sol(beginWord, endWord, wordList);
        return sol2(beginWord, endWord, wordList);
    }

    public int sol(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;

        int res = 0;
        HashSet<String> set = new HashSet<>();
        for (String w : wordList) set.add(w);

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            ++res;
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                for (String s : checkNext(word, set)) {
                    if (s.equals(endWord)) return res + 1;
                    else {
                        set.remove(s);
                        q.offer(s);
                    }
                }
            }
        }
        return 0;        
    }

    public int sol2(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        HashSet<String> wordSet = new HashSet<>();
        for (String w : wordList) wordSet.add(w);
        if (!wordSet.contains(endWord)) return 0;
        HashSet<String> a = new HashSet<>();
        HashSet<String> b = new HashSet<>();
        a.add(beginWord);
        b.add(endWord);

        int res = 0;

        while (!a.isEmpty() || !b.isEmpty()) {
            HashSet<String> tmp = new HashSet<>(a);
            a = new HashSet<>(b);
            b = new HashSet<>(tmp);

            HashSet<String> s = new HashSet<>();
            res++;
            for (String w : a) {
                for (String str : checkNext2(w, wordSet)) {
                    if (b.contains(str)) return res + 1;
                    else {
                        s.add(str);
                    }
                }
            }
            a = new HashSet<>(s);
        }
        return 0;
    }

    public List<String> checkNext(String word, HashSet<String> set) {
        char[] arr = word.toCharArray();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            char old = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                arr[i] = c;
                String s = new String(arr);
                if (set.contains(s)) res.add(s);
            }
            arr[i] = old;
        }
        return res;
    }

    public List<String> checkNext2(String word, HashSet<String> set) {
        char[] arr = word.toCharArray();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            char old = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                arr[i] = c;
                String s = new String(arr);
                if (set.contains(s) && !word.equals(s)) res.add(s);
            }
            arr[i] = old;
        }
        return res;
    }
}
