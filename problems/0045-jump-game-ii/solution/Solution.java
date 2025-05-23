class Solution {
    public int jump(int[] nums) {
        // Number of jumps needed
        int res = 0;

        // l and r define the current "range" we can jump within this step
        int l = 0;
        int r = 0;

        // While we haven’t reached or passed the last index
        while (r < nums.length - 1) {
            int farthest = 0;

            // Within the current range [l, r], find the farthest index we can reach
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            // Move to the next range (next level of jumps)
            l = r + 1;
            r = farthest;

            // We made a jump
            res++;
        }

        return res;
    }
}
