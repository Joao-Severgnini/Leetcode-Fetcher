import java.util.List;

public class Main{
public static void main(String[] args) {
    Solution solution = new Solution();
    int n = 4; // Change this to test with other values
    List<List<String>> solutions = solution.solveNQueens(n);

    // Print all solutions
    int count = 1;
    for (List<String> board : solutions) {
        System.out.println("Solution " + count++ + ":");
        for (String row : board) {
            System.out.println(row);
        }
        System.out.println();
    }
}
}