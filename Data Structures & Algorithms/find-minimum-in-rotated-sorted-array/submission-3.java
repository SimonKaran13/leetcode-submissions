class Solution {
    public int findMin(int[] nums) {
        // [3,4,5,6,1,2]
        //            -
        //      - 
        //        - 
        //          -
        if (nums.length == 1) return nums[0];

        int low = 0;
        int high = nums.length - 1;
        int min = nums[high];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < min) {
                min = nums[mid];
                high = mid - 1;
            } else if (nums[mid] > min) {
                low = mid + 1;
            } else if (low == high) {
                break;
            }
        }
        return min;
    }
}
