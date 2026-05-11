public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // Ensure A is the shorter array
    if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
    int[] A = nums1, B = nums2;
    int m = A.length, n = B.length;

    int half = (m + n + 1) / 2; // extra element goes to the left when odd
    int left = Math.max(0, half - n);
    int right = Math.min(m, half);

    while (left <= right) {
        int i = (left + right) / 2;   // cut in A
        int j = half - i;             // cut in B

        int ALeft  = (i > 0) ? A[i - 1] : Integer.MIN_VALUE;
        int ARight = (i < m) ? A[i] : Integer.MAX_VALUE;
        int BLeft  = (j > 0) ? B[j - 1] : Integer.MIN_VALUE;
        int BRight = (j < n) ? B[j] : Integer.MAX_VALUE;

        if (ALeft <= BRight && BLeft <= ARight) {
            if (((m + n) & 1) == 1) {
                return Math.max(ALeft, BLeft); // odd
            } else {
                // even — average, avoid int overflow by casting first
                return ((double)Math.max(ALeft, BLeft) + (double)Math.min(ARight, BRight)) / 2.0;
            }
        } else if (ALeft > BRight) {
            right = i - 1; // move left
        } else {
            left = i + 1;  // move right
        }
    }
    throw new IllegalStateException("Should never reach here");
}

}