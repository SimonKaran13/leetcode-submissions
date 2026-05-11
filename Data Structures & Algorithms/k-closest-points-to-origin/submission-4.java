class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[] origin = new int[]{0, 0};
        Arrays.sort(points, (p1, p2) -> Double.compare(
            euclideanDistance(p1, origin),
            euclideanDistance(p2, origin))
            );
        
        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }
        return result;
    }

    private double euclideanDistance(int[] p1, int[] p2) {
        double res = Math.sqrt(
            Math.pow(p1[0] - p2[0], 2)
            + 
            Math.pow(p1[1] - p2[1], 2));
        System.out.println(res);
        return res;
    }
}
