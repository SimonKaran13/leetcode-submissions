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
    public ListNode mergeKLists(ListNode[] lists) {
        // Perform mergeSort with List array;
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return mergeTwo(lists[0], lists[1]);
        
        int mid = lists.length / 2;
        ListNode firstHalf = mergeSort(lists, 0, mid);
        ListNode secondHalf = mergeSort(lists, mid + 1, lists.length - 1);

        return mergeTwo(firstHalf, secondHalf);
    }

    private ListNode mergeSort(ListNode[] lists, int bottom, int top) {
        if (bottom == top) return lists[bottom];
        if (top - bottom == 1) return mergeTwo(lists[bottom], lists[top]);
        
        int mid = bottom + (top - bottom) / 2;
        ListNode firstHalf = mergeSort(lists, bottom, mid);
        ListNode secondHalf = mergeSort(lists, mid + 1, top);
        return mergeTwo(firstHalf, secondHalf);
    }

    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1; 
        
        ListNode head = new ListNode();
        ListNode current = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 == null && l2 == null) {
            current.next = null;
        } else if (l1 == null) {
            current.next = l2;
        } else {
            current.next = l1;
        }
        return head.next;
    }
}
