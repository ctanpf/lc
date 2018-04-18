/*
 * [138] Copy List with Random Pointer
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (25.82%)
 * Total Accepted:    153.1K
 * Total Submissions: 593.1K
 * Testcase Example:  '{}'
 *
 * 
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * 
 * 
 * Return a deep copy of the list.
 * 
 */
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode dup = new RandomListNode(cur.label);
            dup.next = cur.next;
            cur.next = dup;
            cur = dup.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        RandomListNode res = new RandomListNode(0);
        RandomListNode cur1 = res;
        cur = head;
        while (cur != null) {
            RandomListNode dup = cur.next;
            cur.next = cur.next.next;
            cur1.next = dup;
            dup.next = null;
            cur1 = cur1.next;
            cur = cur.next;
        }
        return res.next;
    }
}
