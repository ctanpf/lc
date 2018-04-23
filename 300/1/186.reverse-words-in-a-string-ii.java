/*
 * [186] Reverse Words in a String II
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/description/
 *
 * algorithms
 * Medium (30.41%)
 * Total Accepted:    41.2K
 * Total Submissions: 135.3K
 * Testcase Example:  '["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]'
 *
 * 
 * Given an input string, reverse the string word by word. A word is defined as
 * a sequence of non-space characters.
 * 
 * 
 * 
 * The input string does not contain leading or trailing spaces and the words
 * are always separated by a single space.
 * 
 * 
 * 
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * 
 * 
 * Could you do it in-place without allocating extra space?
 * 
 * 
 * Related problem: Rotate Array
 * 
 * 
 * Update (2017-10-16):
 * We have updated the function signature to accept a character array, so
 * please reset to the default code definition by clicking on the reload button
 * above the code editor. Also, Run Code is now available!
 * 
 */
class Solution {
    public void reverseWords(char[] str) {
        if (str == null || str.length < 2) return;
        reverse(str, 0, str.length - 1);
        reverseWord(str);
    }

    public void reverseWord(char[] str) {
        int i = 0;
        int j = 0;
        while (j < str.length) {
            while (i < j || i < str.length && str[i] == ' ') i++;
            while (j < i || j < str.length && str[j] != ' ') j++;
            reverse(str, i, j - 1);
        }
    }

    public void reverse(char[] arr) {
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            while (j < i || j < arr.length && arr[j] != ' ') j++;
            while (i < j || i < arr.length && arr[i] == ' ');
            reverse(arr, i, j - 1);
        }
    }

    public void reverse(char[] str, int i, int j) {
        while (i < j) {
            char tmp = str[i];
            str[i++] = str[j];
            str[j--] = tmp;
        }
    }
}
