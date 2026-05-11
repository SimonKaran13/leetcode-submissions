class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Determine frequency for each num in nums
        Map<Integer, Integer> numToFrequency = new HashMap<>();
        for (int x : nums) {
            numToFrequency.put(x, numToFrequency.getOrDefault(x, 0) + 1);
        }

        // Init buckets
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        // Assign nums to buckets
        for (var entry : numToFrequency.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            buckets.get(frequency - 1).add(num); // Important - 1, we don't have frequency 0
        }

        List<Integer> result = new ArrayList<>();
        // grab top K elements from buckets in decreasing order
        for (int i = nums.length - 1; i >= 0; i--) {
            if (result.size() >= k) break;
            var bucketIterator = buckets.get(i).listIterator();
            while (bucketIterator.hasNext() && result.size() < k) {
                result.add(bucketIterator.next());
            }
        } 

        int[] resultArray = new int[k];
        for (int i = 0; i < k; i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
