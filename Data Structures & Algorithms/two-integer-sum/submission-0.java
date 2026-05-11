class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (valueToIndex.containsKey(diff)) {
                int[] solution  = {valueToIndex.get(diff), i};
                return solution;
            } else {
                valueToIndex.put(nums[i], i);
            }
        }
        return null;  
    }
}
