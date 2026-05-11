class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>(k);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((xs, ys) -> Integer.compare(ys[0], xs[0]));

        for (int i = 0; i < k; i++) {
            int[] current = new int[] {nums[i], i}; 
            maxHeap.add(current);
        }
        res.add(maxHeap.peek()[0]);

        int l = 0;
        int r = l + k;
        while (r < nums.length) {
            l++;
            int[] current = new int[] {nums[r], r};
            maxHeap.add(current);

            while (maxHeap.peek()[1] < l) {
                maxHeap.poll();
            }

            res.add(maxHeap.peek()[0]);
            
            r++;
        }

        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        
        return resArr;
    }
}
