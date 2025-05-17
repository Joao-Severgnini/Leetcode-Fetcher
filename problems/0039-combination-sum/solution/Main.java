import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = solution.combinationSum(candidates, target);

        System.out.println("Combinations that sum to " + target + ":");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
