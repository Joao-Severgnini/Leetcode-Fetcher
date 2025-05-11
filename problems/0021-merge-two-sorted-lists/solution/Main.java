public class Main {
    public static void main(String[] args) {
        // Create list1: 1 -> 3 -> 5
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));

        // Create list2: 2 -> 4 -> 6
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));

        // Merge the lists
        Solution sol = new Solution();
        ListNode merged = sol.mergeTwoLists(list1, list2);

        // Print the merged list
        printList(merged);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}