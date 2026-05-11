/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

       [2,4,6,8]

       1. current 2, last 8, nextNode 4 -> [2, 8, 4, 6]
       2. current 4, last 6, nextnode 6 -> [2, 8, 4, 6]
       3. current 6, last 6, nextNode null
 */

class Solution {
    public void reorderList(ListNode head) {
        // Find out the middle of the list with slow and fast pointer
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Slow is at the middle
        ListNode second = slow.next;
        ListNode prev = slow.next = null; // divide list in 2

        // Reverse second list
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }


        // Merge both lists
        ListNode first = head;
        second = prev;
        while (second != null) {
            var tmp1 = first.next;
            var tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }


    }

    private void reorderSlow(ListNode head) {
        if (head == null) return;
        if (head.next == null) return;
        
        ListNode current = head;
        while (current != null) {
            // Last Node and remove the reference from second last to it
            ListNode last = getLast(current);
           
            // Save the reference to second node in the list
            ListNode nextNode = current.next;
            
            // Set Last Node as the second Node
            current.next = last;

            // Set the previously second node as the third node after the previous last one
            last.next = nextNode;

            // Update the current head
            current = nextNode;
        }
    }

    private ListNode getLast(ListNode head) {
        ListNode previous = head;
        while (head.next != null) {
            previous = head;
            head = head.next;
        }
        previous.next = null;
        return head;
    }
}
