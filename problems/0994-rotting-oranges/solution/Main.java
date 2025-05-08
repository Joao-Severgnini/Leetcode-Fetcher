public class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] grid = {
        { 2, 1, 1 },
        { 1, 1, 0 },
        { 0, 1, 1 }
    };

    int result = solution.orangesRotting(grid);
    System.out.println("Minutos necessários: " + result);
  }
}
