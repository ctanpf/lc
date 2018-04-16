/*
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (33.54%)
 * Total Accepted:    122.2K
 * Total Submissions: 364.5K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
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
    public ListNode partition(ListNode head, int x) {
        ListNode big = new ListNode(0);
        ListNode small = new ListNode(0);
        ListNode b = big;
        ListNode s = small;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                s.next = cur;
                s = s.next;
            }
            else {
                b.next = cur;
                b = b.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        s.next = big.next;
        b.next = null;
        return small.next;
    }
}
