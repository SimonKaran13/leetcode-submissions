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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();

        ListNode current = result;

        int carry = 0;
        while (l1 != null && l2 != null) {
            // Add digits and carry
            int sum = l1.val + l2.val + carry;
            int resultDigit = sum % 10;
            carry = sum / 10;

            // Prepare result node
            ListNode newNode = new ListNode(resultDigit);
            current.next = newNode;
            current = newNode;

            // Iterate over both input lists
            l1 = l1.next;
            l2 = l2.next;
        }

        // Continue l1
        while (l1 != null) {
            // Add digits and carry
            int sum = l1.val + carry;
            int resultDigit = sum % 10;
            carry = sum / 10;

            // Prepare result node
            ListNode newNode = new ListNode(resultDigit);
            current.next = newNode;
            current = newNode;

            l1 = l1.next;
        }

        // Continue l2
        while (l2 != null) {
            // Add digits and carry
            int sum = l2.val + carry;
            int resultDigit = sum % 10;
            carry = sum / 10;

            // Prepare result node
            ListNode newNode = new ListNode(resultDigit);
            current.next = newNode;
            current = newNode;

            l2 = l2.next;
        }

        while (carry > 0) {
            int resultDigit = carry % 10;
            carry = carry / 10;

            ListNode newNode = new ListNode(resultDigit);
            current.next = newNode;
            current = newNode;   
        }

        return result.next;
    }
}
