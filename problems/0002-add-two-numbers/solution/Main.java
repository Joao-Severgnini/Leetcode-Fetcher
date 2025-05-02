public class Main {
  public static void main(String[] args) {

    // Create the linked lists
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);
    
    // Call Solution class and pass the lists
    Solution sol = new Solution();
    ListNode result = sol.addTwoNumbers(l1, l2);

    // Print solution
    sol.printSolution(result);
  }
}
