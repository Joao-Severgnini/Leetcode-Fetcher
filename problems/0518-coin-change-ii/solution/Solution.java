class Solution {
    public int change(int amount, int[] coins) {
        // DP[i] will store the number of ways to make up amount i
        int[] DP = new int[amount + 1]; 
        
        // There is 1 way to make amount 0 — by choosing no coins
        DP[0] = 1;

        // For each coin, update the DP array
        for (int coin : coins) {
            // Start from the value of the coin and update all amounts up to the target amount
            for (int i = coin; i <= amount; i++) {
                // Add the number of ways to make (i - coin) to the current amount
                DP[i] += DP[i - coin];
            }
        }

        // Return the total number of ways to make the target amount
        return DP[amount];
    }
}
