/*
 * [61] Rotate List
 *
 * https://leetcode.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (24.44%)
 * Total Accepted:    136K
 * Total Submissions: 556.2K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * 
 * 
 * Example:
 * 
 * Given 1->2->3->4->5->NULL and k = 2,
 * 
 * return 4->5->1->2->3->NULL.
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res;
        int len = 0;
        while (cur.next != null) {
            ++len;
            cur = cur.next;
        }
        ListNode div = res;
        k = k%len;
        for (int i = 0; i < len - k; i++) div = div.next;
        cur.next = res.next;
        res.next = div.next;
        div.next = null;
        return res.next;
    }
}
