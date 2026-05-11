class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        return sortingSolution(nums, k);
    }

    private int sortingSolution(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
