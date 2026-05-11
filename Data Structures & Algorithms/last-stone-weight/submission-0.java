class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            simulate(maxHeap);
        }

        if (maxHeap.size() == 0) {
            return 0;
        }
        
        return maxHeap.peek();
    }

    private void simulate(PriorityQueue<Integer> maxHeap) {
        int stone1 = maxHeap.poll();
        int stone2 = maxHeap.poll();

        int newStone = stone1 - stone2;
        maxHeap.add(newStone);
    }
}
