/*
 * [179] Largest Number
 *
 * https://leetcode.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (23.52%)
 * Total Accepted:    92.9K
 * Total Submissions: 395K
 * Testcase Example:  '[3, 30, 34, 5, 9]'
 *
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead
 * of an integer.
 * 
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * 
 */
class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                String v1 = a + b;
                String v2 = b + a;
                return v2.compareTo(v1);
            }
        });
        for (String s : arr) sb.append(s);
        int i = 0;
        String res = sb.toString();
        while (i < res.length() && res.charAt(i) == '0') i++;
        if (i == res.length()) return "0";
        return res.substring(i); 
    }
}
