class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    // Create a dummy node that points to the head of the list.
    // This simplifies edge cases, such as reversing the first group.
    ListNode dummy = new ListNode(0, head);

    // This will always point to the node before the current group being reversed
    ListNode groupPrev = dummy;

    // Repeat the process until there are no more complete groups of size k
    while (true) {
      // Find the k-th node from groupPrev (i.e., the end of the group)
      ListNode kth = getKth(groupPrev, k);
      if (kth == null) {
        // If there are fewer than k nodes left, stop (nothing to reverse)
        break;
      }

      // Save the node after the k-th, which will be the start of the next group
      ListNode groupNext = kth.next;

      // We'll now reverse the current group:
      // Start from the first node of the group (right after groupPrev)
      ListNode prev = groupNext;
      ListNode curr = groupPrev.next;

      // Reverse the nodes in the group
      while (curr != groupNext) {
        ListNode tmp = curr.next; // Store next node
        curr.next = prev;         // Reverse current node's pointer
        prev = curr;              // Move prev one step forward
        curr = tmp;               // Move curr one step forward
      }

      // After reversing, connect the previous part of the list to the new head
      ListNode tmp = groupPrev.next; // tmp holds the original head of the group (now the tail)
      groupPrev.next = kth;          // groupPrev should now point to the new head of the group
      groupPrev = tmp;               // Move groupPrev to the end of the reversed group
    }

    // Return the new head of the list (right after dummy)
    return dummy.next;
  }

  // Helper method to get the k-th node starting from 'curr'
  // Returns null if there are fewer than k nodes ahead
  private ListNode getKth(ListNode curr, int k) {
    while (curr != null && k > 0) {
      curr = curr.next;
      k--;
    }
    return curr;
  }
}
