class Solution {
    public int maxProduct(int[] nums) {
        int res = max(nums);

        int len = nums.length;
        for (int start = 0; start < len; start++) {
            for (int end = start + 1; end < len; end++) {
                int current = 1;
                for (int i = start; i <= end; i++) {
                    current *= nums[i];
                }
                res = Math.max(res, current);
            }
        } 

        return res;
    }

    private int max(int[] nums) {
        int max = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
        }
        return max;
    }
}
