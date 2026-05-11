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
        long n1 = 0L;
        for (int i = 0; l1 != null; i++, l1 = l1.next) {
            long val = l1.val;
            long scaler = (long) Math.pow(10, i);
            long scaled = val * scaler;
            n1 += scaled;
        }

        long n2 = 0L;
        for (int i = 0; l2 != null; i++, l2 = l2.next) {
            long val = l2.val;
            long scaler = (long) Math.pow(10, i);
            long scaled = val * scaler;
            n2 += scaled;
        }

        long res = n1 + n2;
        String[] digits = Long.toString(res).split("");
        
        ListNode tmp = new ListNode();
        ListNode pointer = tmp;
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = Integer.valueOf(digits[i]);
            ListNode newNode = new ListNode(val);
            tmp.next = newNode;
            tmp = tmp.next;
        }

        return pointer.next;

    }
}
