class Solution {
    // Cycle detection

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preReqMap = new HashMap<>();
        for (int[] prereq : prerequisites) {
            List<Integer> prereqs = preReqMap.getOrDefault(prereq[0], new ArrayList<>());
            prereqs.add(prereq[1]);
            preReqMap.put(prereq[0], prereqs);
        }
       
        HashSet<Integer> visited = new HashSet<>();
        for (int course = 0; course < numCourses; course++) {
            if (!canFinish(course, preReqMap, visited)) return false;
        }


        return true;
    }

    private boolean canFinish(int course, Map<Integer, List<Integer>> preReqMap, HashSet<Integer> visited) {
        if (visited.contains(course)) return false;

        if (preReqMap.getOrDefault(course, List.of()).isEmpty()) return true;

        visited.add(course);
       
        for (int preReq : preReqMap.get(course)) {
            if (!canFinish(preReq, preReqMap, visited)) return false;
        }

        visited.remove(course);
        preReqMap.put(course, List.of());
        return true;
    }
}
