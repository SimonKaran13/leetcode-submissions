class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int n : nums) {
            int frequency = frequencies.getOrDefault(n, 0);
            frequencies.put(n, frequency + 1);
        }

        for (var entry : frequencies.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
