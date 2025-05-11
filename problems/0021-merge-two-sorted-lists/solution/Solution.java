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
        // Create a dummy node to simplify the process of building the merged list
        ListNode dummy = new ListNode();
        // Pointer to build the new merged list
        ListNode cur = dummy;

        // Traverse both lists as long as neither is null
        while (list1 != null && list2 != null) {
            // Compare current values of both lists
            if (list1.val > list2.val) {
                // If list2's value is smaller, add it to the merged list
                cur.next = list2;
                list2 = list2.next;
            } else {
                // If list1's value is smaller or equal, add it to the merged list
                cur.next = list1;
                list1 = list1.next;
            }

            // Move the pointer forward in the merged list
            cur = cur.next;
        }

        // At this point, one of the lists is null
        // Append the non-null list (if any) to the merged list
        cur.next = (list1 == null) ? list2 : list1;

        // Return the merged list, skipping the dummy node
        return dummy.next;
    }
}
