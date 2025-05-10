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
        // Create a dummy node before the head. This helps simplify edge cases,
        // like when the head itself needs to be removed.
        ListNode res = new ListNode(0, head);
        ListNode dummy = res;

        // Move the 'head' pointer n steps forward
        for (int i = 0; i < n; i++) {
            head = head.next;
        }

        // Move both 'head' and 'dummy' forward together until 'head' reaches the end.
        // At that point, 'dummy' will be right before the node to be removed.
        while (head != null) {
            head = head.next;
            dummy = dummy.next;
        }

        // Skip the node to be deleted
        dummy.next = dummy.next.next;

        // Return the new head of the list
        return res.next;
    }
}
