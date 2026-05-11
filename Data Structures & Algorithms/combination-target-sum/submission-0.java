class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        recurse(nums, target, res, new ArrayList<Integer>());

        return res;
    }

    private void recurse(int[] nums, int target, List<List<Integer>> res, List<Integer> current) { 
        if (target < 0) {   
            return;
        }
        if (target == 0) {
            res.add(current);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int[] modifiedNums = Arrays.copyOfRange(nums, i, nums.length);
            int num = nums[i];
            List<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.add(num);
            recurse(modifiedNums, target - num, res, newCurrent);
        }
    }
}
