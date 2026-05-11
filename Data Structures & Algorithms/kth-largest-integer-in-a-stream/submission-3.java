class KthLargest {
    // Min heap with 
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            minHeap.add(num);
        }
        shrinkHeap();
    }
    
    public int add(int val) {
        minHeap.add(val);
        shrinkHeap();

        int result = minHeap.peek();
        
        return result;
    }

    private void shrinkHeap() {
        while (minHeap.size() > k) {
            minHeap.poll();
        }
    }
}
