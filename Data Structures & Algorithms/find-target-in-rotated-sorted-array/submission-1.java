class Solution {
    public int search(int[] nums, int target) {
        // [5,1,2,3,4] --- t = 1

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            if (nums[low] == target) return low;
            if (nums[high] == target) return high;

            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                if (nums[low] >= target && nums[low] < nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else { // nums[mid] < target
                if (nums[low] >= target && nums[low] > nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
}
