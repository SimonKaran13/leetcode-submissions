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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode result;
        
        if (list1.val <= list2.val) {
            result = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            result = new ListNode(list2.val);
            list2 = list2.next;
        }

        ListNode list3 = result;
        
        while (list1 != null && list2 != null) {
            int nextVal;
            if (list1.val <= list2.val) {
                nextVal = list1.val;
                list1 = list1.next;
            } else {
                nextVal = list2.val;
                list2 = list2.next;
            }
            list3.next = new ListNode(nextVal);
            list3 = list3.next;
        }
        while (list1 != null) {
            list3.next = new ListNode(list1.val);
            list3 = list3.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            list3.next = new ListNode(list2.val);
            list3 = list3.next;
            list2 = list2.next;
        }

        return result;
    }

    // [-9, ]
}