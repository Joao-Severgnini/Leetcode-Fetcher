import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Solution sol = new Solution();

    System.out.print("Digite os números: ");
    String string = scanner.nextLine();
    System.out.println(sol.letterCombinations(string));

    scanner.close();
  }
}