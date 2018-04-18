/*
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (28.49%)
 * Total Accepted:    102.7K
 * Total Submissions: 360.6K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example:
 * Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        // return sol(s);
        return sol2(s);
    }

    public List<String> sol(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        for (int i = 1; i < s.length() - 2 && i < 4; i++) {
            for (int j = i + 1; j < s.length() - 1 && j < i + 4; j++) {
                for (int k = j + 1; k < s.length() && k < j + 4; k++) {
                    String a = s.substring(0, i);
                    String b = s.substring(i, j);
                    String c = s.substring(j, k);
                    String d = s.substring(k);
                    if (isValid(a) && isValid(b) && isValid(c) && isValid(d)) {
                        res.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }
        return res;
    }

    public boolean isValid(String s) {
       if (s.length() == 0 || s.length() > 3 || s.length() > 1 && s.charAt(0) == '0' || Integer.parseInt(s) > 255) return false;
       return true;
    }

    public List<String> sol2(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        check(res, "", 0, s);
        return res;
    }

    public void check(List<String> res, String tmp, int num, String s) {
        if (num == 4) {
            if (s.length() == 0) res.add(tmp);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (s.length() < i) break;
            String substr = s.substring(0, i);
            int val = Integer.parseInt(substr);
            if (isValid(substr)) {
                check(res, tmp + substr + (num == 3 ? "" : "."), num + 1, s.substring(i));
            }
        }
    }


}
