import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite um número: ");
    int num = scanner.nextInt();

    Solution sol = new Solution();

    int reversed = sol.reverse(num);
    System.out.println("O número invertido é: " + reversed);

    scanner.close();
  }
}