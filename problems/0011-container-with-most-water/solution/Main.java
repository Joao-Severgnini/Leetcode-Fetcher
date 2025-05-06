import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Qual será o tamanho do array de alturas? ");
    int tamanho = scanner.nextInt();

    int[] heigth = new int[tamanho];
    for (int i = 0; i < tamanho; i++) {
      System.out.print("Digite a " + (i + 1) + "ª altura: ");
      heigth[i] = scanner.nextInt();
    }
    Solution sol = new Solution();
    int areaTotal = sol.maxArea(heigth);
    System.out.println("AreaTotal: " + areaTotal);
    scanner.close();
  }
}