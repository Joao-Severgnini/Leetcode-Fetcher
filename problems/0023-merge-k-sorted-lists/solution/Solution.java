import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {

    // If the input array is null or empty, return null
    if (lists == null || lists.length == 0) {
      return null;
    }

    // Keep merging the lists until only one list remains
    while (lists.length > 1) {

      // This list will store the merged results of pairs of lists
      List<ListNode> mergedLists = new ArrayList<>();

      // Merge lists in pairs (list[i] with list[i + 1])
      for (int i = 0; i < lists.length; i += 2) {
        ListNode list1 = lists[i];

        // If there's a next list, use it; otherwise, set list2 to null
        ListNode list2 = (i + 1 < lists.length) ? lists[i + 1] : null;

        // Merge the two lists and add the result to mergedLists
        mergedLists.add(mergeTwoLists(list1, list2));
      }

      // Convert the merged list back to an array for the next iteration
      lists = mergedLists.toArray(new ListNode[0]);
    }

    // Return the final merged list
    return lists[0];
  }


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
