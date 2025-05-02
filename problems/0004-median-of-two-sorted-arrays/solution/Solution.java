class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Assign nums1 and nums2 to A and B for clarity
        int[] A = nums1;
        int[] B = nums2;

        // Ensure A is the smaller array for binary search efficiency
        if (A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        // Calculate total length and the mid point of the combined arrays
        int total = A.length + B.length;
        int mid = (total + 1) / 2;

        // Binary search range on the smaller array
        int L = 0;
        int R = A.length;

        while (L <= R) {
            // Partition index for A
            int midA = (L + R) / 2;

            // Corresponding partition index for B
            int midB = mid - midA;

            // Edge values to handle out-of-bounds gracefully
            int aLeft = (midA == 0) ? Integer.MIN_VALUE : A[midA - 1];
            int aRight = (midA == A.length) ? Integer.MAX_VALUE : A[midA];
            int bLeft = (midB == 0) ? Integer.MIN_VALUE : B[midB - 1];
            int bRight = (midB == B.length) ? Integer.MAX_VALUE : B[midB];

            // Check if partition is valid
            if (aLeft <= bRight && bLeft <= aRight) {
                // Odd total length: return the max of left values
                if (total % 2 != 0) {
                    return (double) Math.max(aLeft, bLeft);
                } else {
                    // Even total length: return average of max left and min right
                    return (double) (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2;
                }
            } else {
                // Adjust binary search range
                if (aLeft > bRight) {
                    R = midA - 1;
                } else {
                    L = midA + 1;
                }
            }
        }

        // Fallback return (the algorithm should always return inside the loop)
        return 0.0;
    }
}
