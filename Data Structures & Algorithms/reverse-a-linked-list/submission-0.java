/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;


        ListNode tail = new ListNode(head.val);
        ListNode next = head.next;

        while (next != null) {
            ListNode current = new ListNode(next.val, tail);
            tail = current;
            next = next.next;
        }
        return tail;
    }

        // [0] -> [1] -> [2] -> [3] -> null
        //  cur    nxt   nxtNxt

        //  [0] <- [1]    [2] -> [3] -> null
}
