import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Give me the amount: ");
    int amount = scanner.nextInt();

    System.out.print("How many coins do you want? ");
    int quantity = scanner.nextInt();

    int[] coins = new int[quantity];
    System.out.println("Give me the coins: ");
    for (int i = 0; i < quantity; i++) {
      System.out.print("Coin " + i + ": ");
      coins[i] = scanner.nextInt();
    }

    Solution sol = new Solution();
    int result = sol.change(amount, coins);
    System.out.println("The result is " + result);

    scanner.close();
  }
}
