class Solution {
    // Ask if the Array is sorter
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        
        // Create set to check numbers in nums in O(1) -> Creation in O(n)
        Set<Integer> numsSet = new HashSet<>();
        for (int x : nums) {
            numsSet.add(x);
        }

        int longestSeq = 1;
        for (int i = 0; i < nums.length; i++) {
            
            int num = nums[i];
            
            // Check if it's the start of a sequence otherwise continue
            if (numsSet.contains(num - 1)) continue;

            // Check sequence lenght
            int currentSeq = 1;
            while (numsSet.contains(num + 1)) {
                currentSeq++;
                num++;
            }
            
            // Check if current sequence is the longest
            if (currentSeq > longestSeq) longestSeq = currentSeq;
        }

        return longestSeq;
    }
}
