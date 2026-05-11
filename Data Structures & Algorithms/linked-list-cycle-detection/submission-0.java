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
    public boolean hasCycle(ListNode head) {
        if (head.next == null) return false;

        ListNode pointer = head;
        ListNode fastPointer = head.next;
        
        while (pointer != null) {
            if (pointer == fastPointer) return true;
            pointer = pointer.next;
            if (fastPointer.next != null) fastPointer = fastPointer.next.next;
            else break;

        }
        return false;
    }
}
