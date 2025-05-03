import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Solution sol = new Solution();

    System.out.print("Type some palindromic: ");
    String input = scanner.nextLine();
    String output = sol.longestPalindrome(input);
    System.out.println("The longest is: " + output);
    scanner.close();
  }
}
