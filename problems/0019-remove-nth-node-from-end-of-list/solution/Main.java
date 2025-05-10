import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    int n;
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next.next.next = new ListNode(8);
    head.next.next.next.next.next.next.next.next = new ListNode(9);

    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite um numero de 1 a 9: ");
    do {
      n = scanner.nextInt();
    } while (n < 1 || n > 9);

    Solution sol = new Solution();
    ListNode updatedHead = sol.removeNthFromEnd(head, n);
    printList(updatedHead);
    scanner.close();
  }

  public static void printList(ListNode head) {
    while (head != null) {
      System.out.print(head.val);
      if (head.next != null) {
        System.out.print("->");
      }
      head = head.next;
    }
    System.out.println("");
  }
}
