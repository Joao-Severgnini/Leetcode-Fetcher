public class Main {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(3, new ListNode(4, new ListNode(5)));
    ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(8)));
    ListNode l3 = new ListNode(2, new ListNode(7, new ListNode(8)));

    ListNode[] lists = new ListNode[] { l1, l2, l3 };

    Solution solution = new Solution();
    ListNode result = solution.mergeKLists(lists);

    System.out.println("Lista mesclada: ");
    System.out.println(result);
  }
}