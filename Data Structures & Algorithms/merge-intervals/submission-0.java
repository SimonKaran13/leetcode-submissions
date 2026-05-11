class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.sort((i1, i2) -> i1[0] == i2[0] ? Integer.compare(i2[1], i1[1]) : Integer.compare(i1[0], i2[0]));

        ArrayList<int[]> res = new ArrayList<>();
        for (int[] interval : list) {
            if (res.isEmpty()) {
                res.add(interval);
                continue;
            }

            int[] lastInterval = res.get(res.size() - 1);
            if (lastInterval[1] < interval[0]) {
                res.add(interval);
                continue;
            }
            if (lastInterval[1] >= interval[0]) {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
                continue;
            }
        }

        int[][] result = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
