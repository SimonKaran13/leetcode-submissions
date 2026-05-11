class Solution {
    public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return n;
        

        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> children = edgeMap.getOrDefault(edge[0], new ArrayList<>());
            children.add(edge[1]);
            edgeMap.put(edge[0], children);

            children = edgeMap.getOrDefault(edge[1], new ArrayList<>());
            children.add(edge[0]);
            edgeMap.put(edge[1], children);
        }
        
        int res = 0;

        HashSet<Integer> visited = new HashSet<>();
        for (int node = 0; node < n; node++) {
            if (!visited.contains(node)) {
                res++;
                dfsExplore(edgeMap, visited, node, -1);
            }
            
        }

        return res;
    }


    private void dfsExplore(Map<Integer, List<Integer>> edgeMap, HashSet<Integer> visited, int node, int parent) {
        if (visited.contains(node)) return;

        visited.add(node);

        for (int child : edgeMap.getOrDefault(node, List.of())) {
            if (child == parent) continue;
            dfsExplore(edgeMap, visited, child, node);
        }
    }
}
