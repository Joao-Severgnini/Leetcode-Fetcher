import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Solution sol = new Solution();

    System.out.print("Numero de pares n: ");
    int n = scanner.nextInt();

    System.out.println(sol.generateParenthesis(n));
    scanner.close();
  }
}