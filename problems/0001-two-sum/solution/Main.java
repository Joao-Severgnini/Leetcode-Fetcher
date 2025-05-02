import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    // Create an instance of the Solution class
    Solution solution = new Solution();

    // Define the input array and target value
    int[] nums = { 2, 7, 11, 15 };
    int target = 9;

    // Call the twoSum method to find the indices of the two numbers that add up to the target
    int[] result = solution.twoSum(nums, target);

    // Check if a valid pair was found and print the result
    if (result.length == 2) {
      System.out.println("Indices encontrados: " + Arrays.toString(result));
    } else {
      System.out.println("Nenhuma combinação encontrada.");
    }
  }
}
