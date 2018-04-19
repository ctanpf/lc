/*
 * [151] Reverse Words in a String
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (15.62%)
 * Total Accepted:    195.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '""'
 *
 * 
 * Given an input string, reverse the string word by word.
 * 
 * 
 * 
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * 
 * 
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 * 
 * 
 * click to show clarification.
 * 
 * Clarification:
 * 
 * 
 * 
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing
 * spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 * 
 * 
 * 
 */
public class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length - 1);
        reverseWord(arr);
        return trimSpace(arr);
    }

    public void reverseWord(char[] arr) {
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            while (i < j || i < arr.length && arr[i] == ' ') i++;
            while (j < i || j < arr.length && arr[j] != ' ') j++;
            reverse(arr, i, j - 1);
        }
    }

    public String trimSpace(char[] arr) {
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            while (j < arr.length && arr[j] == ' ') j++;
            while (j < arr.length && arr[j] != ' ') arr[i++] = arr[j++];
            while (j < arr.length && arr[j] == ' ') j++;
            if (j < arr.length) arr[i++] = ' ';
        }
        return new String(arr).substring(0, i);
    }

    public void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char tmp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = tmp;
        }
    }
}
