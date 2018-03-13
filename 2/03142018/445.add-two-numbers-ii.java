/*
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (46.15%)
 * Total Accepted:    45.1K
 * Total Submissions: 97.7K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the
 * lists is not allowed.
 * 
 * 
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        while (l1 != null) {
            a.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            b.push(l2.val);
            l2 = l2.next;
        }
        ListNode res = new ListNode(0);
        int carry = 0;
        while (!a.isEmpty() || !b.isEmpty()) {
            int sum = (a.isEmpty() ? 0 : a.pop()) + (b.isEmpty() ? 0 : b.pop()) + carry;
            carry = sum/10;
            sum %= 10;
            ListNode node = new ListNode(sum);
            node.next = res.next;
            res.next = node;
        }
        if (carry == 1) {
            ListNode node = new ListNode(1);
            node.next = res.next;
            res.next = node;
        }
        return res.next;
    }
}
