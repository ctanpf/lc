/*
 * [539] Minimum Time Difference
 *
 * https://leetcode.com/problems/minimum-time-difference/description/
 *
 * algorithms
 * Medium (46.04%)
 * Total Accepted:    15.2K
 * Total Submissions: 33K
 * Testcase Example:  '["23:59","00:00"]'
 *
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the
 * minimum minutes difference between any two time points in the list. 
 * 
 * Example 1:
 * 
 * Input: ["23:59","00:00"]
 * Output: 1
 * 
 * 
 * 
 * Note:
 * 
 * The number of time points in the given list is at least 2 and won't exceed
 * 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 * 
 * 
 */
class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] timeArr = new boolean[1440];

        for (String s : timePoints) {
            String[] t = s.split(":");
            int hr = Integer.parseInt(t[0]);
            int mn = Integer.parseInt(t[1]);
            if (timeArr[60 * hr + mn]) return 0;
            else timeArr[60 * hr + mn] = true;
        }

        int res = Integer.MAX_VALUE;
        int cur = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 1440; i++) {
            if (timeArr[i]) {
                min = Math.min(min, i);
                max = Math.max(max, i);
                if (cur == -1) cur = i;
                else {
                    res = Math.min(res, i - cur);
                    cur = i;
                }
            }
        }
        res = Math.min(1440 - max + min, res);
        return res;
    }
}
