class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        rec(new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void rec(List<Integer> perm, int[] nums, boolean[] pick) {
        if (perm.size() == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                perm.add(nums[i]);
                pick[i] = true;

                rec(perm, nums, pick);

                perm.remove(perm.size() - 1);
                pick[i] = false;
            }
        }


    }
}
