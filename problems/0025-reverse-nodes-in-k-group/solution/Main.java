public class Main {
  public static void main(String[] args) {
    ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

    Solution solution = new Solution();
    int k = 2;
    System.out.println(solution.reverseKGroup(list, k));
  }
}

