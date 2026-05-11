class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        int zeroCount = 0;
        for (int x : nums) {
            if (x == 0) {
                zeroCount++;
            } else {
                totalProduct *= x;
            }
        }

        int[] result = new int[nums.length];
        if (zeroCount > 1) return result;
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 1) {
                if (nums[i] == 0) result[i] = totalProduct;
                else result[i] = 0;
            } else {
                result[i] = totalProduct / nums[i];
            }
        }
        return result;
    }
}  
