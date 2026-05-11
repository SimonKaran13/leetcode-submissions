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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        List<ListNode> groups = new ArrayList<>();
        int groupCount = 0;
        int kGroupCount = 0;
        int currentGroupCount = 0;
        // Separate groups
        while (head != null) {
            if (currentGroupCount == 0) {
                groups.add(head);
            }

            currentGroupCount++;

            if (currentGroupCount == k) {
                groupCount++;
                kGroupCount++;
                currentGroupCount = 0;
                ListNode tmp = head;
                head = head.next;
                tmp.next = null;
            } else {
                head = head.next;
            }

        }
        // Last Group does not have k nodes
        if (currentGroupCount != 0) groupCount++;

        // Reverse K groups and concat them
        ListNode reversed = null;
        for (int i = 0; i < groupCount; i++) {
            ListNode group = groups.get(i);
            if (i < kGroupCount) {
                reversed = concatList(reversed, reverseList(group));
            } else {
                reversed = concatList(reversed, group);
            }
            
        }

        return reversed;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode concatList(ListNode l1, ListNode l2) {
        printList(l1);
        printList(l2);
        if (l1 == null) return l2;

        ListNode tmp = l1;

        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = l2;

        return l1;
    }

    private void printList(ListNode l) {
        List<String> vals = new ArrayList<>();
        while (l != null) {
            vals.add(String.valueOf(l.val));
            l = l.next;
        }
        System.out.println("[" + String.join(", ", vals) + "]");
    }
}
