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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLength(head);
        int index = len - n;
        if (index < 0) throw new IllegalArgumentException();

        ListNode current = head;
        ListNode previous = null;
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }
        if (previous == null && current.next == null) {
            return null;
        } else if (previous == null && current.next != null) {
            return current.next;
        }
        else {
            previous.next = current.next;
        }
        return head;
    }

    private int getLength(ListNode head) {
        if (head == null) return 0;
        else return 1 + getLength(head.next);
    }
}
