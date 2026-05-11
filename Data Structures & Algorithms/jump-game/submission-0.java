class Solution {
    public boolean canJump(int[] nums) {
        boolean[] canReach = new boolean[nums.length];
        canReach[nums.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            int jumpLen = nums[i];
            boolean isPossible = false;
            for (int j = 1; j <= jumpLen; j++) {
                if (i + j >= nums.length) continue;

                isPossible |= canReach[i + j];
            }
            canReach[i] = isPossible;
        }

        return canReach[0];
    }   
}
