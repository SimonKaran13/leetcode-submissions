class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        i: [-1,0,1,2,-1,-4]
        o: [[-1, -1 ,2], [-1, 2, -1]]               ]

        Idea 1: Bruteforce solution ~ O(n^3)

        Idea 2: rewrite the formula
        nums[i] + nums[j] + nums[k] == 0
        
        -nums[k] = nums[i] + nums[j] ~ O(nˆ2)

        Idea 3: Sorting and doing 2 sum
        */

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }

        }
        return res;        
    }
}
