class Solution {
    public int climbStairs(int n) {
       // return climbStairsRec(0, n);

        int[] cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return climbStairsTopDownMemo(0, n, cache);
    }

    private int climbStairsRec(int current, int target) {
        if (current == target) return 1;
        if (current > target) return 0;
        return climbStairsRec(current + 1, target) + climbStairsRec(current + 2, target);
    }

    private int climbStairsTopDownMemo(int current, int target, int[] cache) {
        if (current == target) return 1;
        if (current > target) return 0;
        if (cache[current] != -1) return cache[current];
        cache[current] = climbStairsTopDownMemo(current + 1, target, cache) + climbStairsTopDownMemo(current + 2, target, cache);
        return cache[current];
    }
    
}
