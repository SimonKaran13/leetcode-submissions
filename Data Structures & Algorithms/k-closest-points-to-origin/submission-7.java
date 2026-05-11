class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[] origin = new int[]{0, 0};
        PriorityQueue<int[]> q = new PriorityQueue<>((p1, p2) -> Double.compare(
            euclideanDistance(p2, origin), // First p2
            euclideanDistance(p1, origin) // second p1 for inverted order (max Heap)
        ));

        // add points to the queue
        for (int[] point : points) {
            q.add(point);

            // remove until we have the top k
            while (q.size() > k) {
                q.poll();
            }
        }

        // get result array
        return q.toArray(new int[k][]);
    }

    private double euclideanDistance(int[] p1, int[] p2) {
        double res = Math.sqrt(
            Math.pow(p1[0] - p2[0], 2)
            + 
            Math.pow(p1[1] - p2[1], 2));
        return res;
    }
}
