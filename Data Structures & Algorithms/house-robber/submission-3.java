class Solution {
    int max = 0;
    public int rob(int[] nums) {
        // recSolution(nums); return max;


        // Top Down + Memoization
        //return topDownMemoizationSolution(nums, 0, false, new HashMap<>());

        // Bottom up DP
        return bottomUpSolution(nums);
    }

    private int bottomUpSolution(int[] nums) {
        int prevMax = 0;
        int prevPrevMax = 0;
        int currentMax = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            currentMax = Math.max(prevMax, nums[i] + prevPrevMax);
            prevPrevMax = prevMax;
            prevMax = currentMax;
        }

        return currentMax;
    }


    private int topDownMemoizationSolution(int[] nums,
                                            int current,
                                            boolean prevRobbed,
                                            HashMap<Pair<Integer, Boolean>, Integer> cache) {

        Pair<Integer, Boolean> pair = new Pair<>(current, prevRobbed);
        if (current >= nums.length) return 0;
        if (cache.containsKey(pair)) return cache.get(pair);
        else {
            int max;
            if (prevRobbed) {
                max = topDownMemoizationSolution(nums, current + 1, false, cache);
            } else {
                max = Math.max(
                    nums[current] + topDownMemoizationSolution(nums, current + 1, true, cache), 
                    topDownMemoizationSolution(nums, current + 1, false, cache));
            }
            cache.put(pair, max);
            return cache.get(pair);
        }
    }




    private void recSolution(int[] nums) {
        max = 0;

        rec(nums, 0, false, 0);
        rec(nums, 0, true, 0);
    }

    private void rec(int[] nums, int current, boolean prevRobbed, int currentlyRobbed) {
        if (current >= nums.length) return;


        if (!prevRobbed) {
            int robbed = nums[current];
            max = Math.max(max, currentlyRobbed + robbed);
            rec(nums, current + 1, true, currentlyRobbed + robbed);
        }

        rec (nums, current + 1, false, currentlyRobbed);
    }
}
