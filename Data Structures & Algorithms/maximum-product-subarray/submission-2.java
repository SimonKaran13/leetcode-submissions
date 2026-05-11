class Solution {
    public int maxProduct(int[] nums) {
        return kadane(nums);
    }

    private int kadane(int[] nums) {
        int res = max(nums);
        int curMax = 1;
        int curMin = 1;

        for (int x : nums) {
            if (x == 0) {
                curMax = 1;
                curMin = 1;
                continue;
            }
            int tmpMax = curMax;
            curMax = Math.max(Math.max(x * curMax, x * curMin), x);
            curMin = Math.min(Math.min(x * tmpMax, x * curMin), x);
            res = Math.max(res, curMax);
        }

        return res;
    }

    private int brute(int[] nums) {
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
