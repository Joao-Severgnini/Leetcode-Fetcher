import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite uma string: ");
    String s = scanner.nextLine();

    System.out.print("Digite um padrão: ");
    String p = scanner.nextLine();

    Solution sol = new Solution();

    boolean res = sol.isMatch(s, p);

    System.out.println("O resutado é: " + res);
    scanner.close();
  }
}