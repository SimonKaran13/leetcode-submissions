class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        
        for (int[] edge : edges) {
            List<Integer> children = edgeMap.getOrDefault(edge[0], new ArrayList<>());
            children.add(edge[1]);
            edgeMap.put(edge[0], children);

            children = edgeMap.getOrDefault(edge[1], new ArrayList<>());
            children.add(edge[0]);
            edgeMap.put(edge[1], children);
        }

        HashSet<Integer> visited = new HashSet<>();
        int firstNode = 0;
        return dfs(edgeMap, firstNode, -1, visited) && visited.size() == n;
    }

    private boolean dfs(Map<Integer, List<Integer>> edgeMap, int node, int parent, HashSet<Integer> visited) {
        if (visited.contains(node)) return false;
        else {
            visited.add(node);
            List<Integer> children = edgeMap.getOrDefault(node, List.of());
            boolean valid = true;
            for (int child : children) {
                if (child == parent) continue;
                valid &= dfs(edgeMap, child, node, visited);
            }
            return valid;
        }
    }
}
