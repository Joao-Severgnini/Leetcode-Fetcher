import java.util.List;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums = {1, 2, 3}; // Example input
        List<List<Integer>> permutations = solution.permute(nums);

        System.out.println("Permutations:");
        for (List<Integer> perm : permutations) {
            System.out.println(perm);
        }
    }
}
