class Solution {
    public int maxSubArray(int[] nums) {
        int res = -1001;
        int curMax = res;
        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
