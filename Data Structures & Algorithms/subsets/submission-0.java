class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, result, nums, new ArrayList<>());
        return result;
    }

    private void dfs(int i, List<List<Integer>> result, int[] nums, List<Integer> subset) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // Take nums[i]
        subset.add(nums[i]); 
        dfs(i + 1, result, nums, subset);

        // Remove nums[i]
        subset.remove(subset.size() - 1);
        dfs(i + 1, result, nums, subset);

    }
}
