class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        return Math.max(
            bottomUp(Arrays.copyOfRange(nums, 1, nums.length)),
            bottomUp(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    private int bottomUp(int[] nums) {

        int prevMax = 0;
        int prevPrevMax = 0;
        int currentMax = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            currentMax = Math.max(nums[i] + prevPrevMax, prevMax);
            prevPrevMax = prevMax;
            prevMax = currentMax;
        }
        return currentMax;
    }
}
