import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> groupedAnagrams = solution.groupAnagrams(input);

        // Print the result
        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }
}
