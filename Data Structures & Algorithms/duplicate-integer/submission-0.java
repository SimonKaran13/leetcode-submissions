class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> duplicates = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (duplicates.contains(x)) {
                return true;
            }
            duplicates.add(x);
        }
        return false;
    }
}