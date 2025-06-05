public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean result = solution.checkInclusion(s1, s2);
        System.out.println("Does s2 contain a permutation of s1? " + result);
        // Expected output: true
    }
}
