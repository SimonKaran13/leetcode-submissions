class Solution {
    public int leastInterval(char[] tasks, int n) {
        // First we need to count the frequencies
        // for this we can use an array of size 26 (A - Z chars)
        int[] frequencies = new int[26];
        for (char t : tasks) {
            frequencies[t - 'A'] += 1;
        }

        // Now we need to populate our max heap to know which task to process first
        // We should process the task that requires the most cycles first.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // IMPORTANT: We don't actually care about which task it is from this point on
        // we only care about how long it takes to complete
        for (int freq : frequencies) {
            if (freq > 0) {
                maxHeap.add(freq);
            }
        }

        int cycles = 0;

        // We need a queue to track when (which cycle) can we reschedule a task after processing it
        Queue<int[]> q = new LinkedList<>();

        // We process until there are no more tasks
        while (!maxHeap.isEmpty() || !q.isEmpty()) {

            System.out.println("cycle: " + cycles + ", heap: " + maxHeap + ", q: " + q.size());

            // If a task in the Queue can be processed again we add it to the heap
            if (!q.isEmpty() && cycles > q.peek()[1]) {
                System.out.println("Polled: {" + q.peek()[0] + ", " + q.peek()[1] + "}");
                maxHeap.add(q.poll()[0]);
            }

            if (!maxHeap.isEmpty()) {
                int freq = maxHeap.poll();
                freq--;

                // After processing the task, we add it to the queue if it still has to be processed
                if (freq > 0) {
                    q.add(new int[]{freq, cycles + n});
                }
            }

            cycles++;
        }

        return cycles;
    }
}
