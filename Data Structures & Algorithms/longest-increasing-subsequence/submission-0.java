class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LISatIndex = new int[nums.length];
        int res = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int maxLen = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i] && LISatIndex[j] + 1 > maxLen) {
                    maxLen = LISatIndex[j] + 1;
                }
            }
            LISatIndex[i] = maxLen;
            if (maxLen > res) {
                res = maxLen;
            }
        }

        return res;
    }

}
