
// [1, 2, 1]
//1       []        -               [1]
//2   []     [2]    -       [1]           [1, 2]
//1 [] [1] [2] [2, 1] -   [1] [1, 1]   [1, 2]  [1, 2, 1]

// [] [1]  [2] [1, 2]    [1] [1, 1]  [1, 2]  [1, 1, 2]

class Solution {
    Set<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new HashSet<>();
        Arrays.sort(nums);

        rec(0, nums, new ArrayList<>());

        return result.stream().toList();
    }

    private void rec(int i, int[] nums, List<Integer> subset) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // Take nums[i]
        subset.add(nums[i]);
        rec(i + 1, nums, subset);

        // Don't take nums[i]
        subset.remove(subset.size() - 1);
        rec(i + 1, nums, subset);
    }
}
