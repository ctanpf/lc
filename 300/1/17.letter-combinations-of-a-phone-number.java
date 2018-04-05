/*
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (36.42%)
 * Total Accepted:    227.9K
 * Total Submissions: 625.7K
 * Testcase Example:  '""'
 *
 * Given a digit string, return all possible letter combinations that the
 * number could represent.
 * 
 * 
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * 
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 
 * Note:
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        recur(res, digits, 0, "", keys);
        return res;
    }

    public void recur(List<String> res, String digits, int index, String tmp, String[] keys) {
        if (index == digits.length()) {
            res.add(tmp);
            return;
        }
        int num = digits.charAt(index) - '0';
        String val = keys[num];
        for (int i = 0; i < val.length(); i++) {;
            recur(res, digits, index + 1, tmp + val.charAt(i), keys);
        }
    }
}
