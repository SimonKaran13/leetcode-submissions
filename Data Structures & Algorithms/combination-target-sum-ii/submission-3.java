

// c = [1, 2, 3, 4, 5], t = 7
// c1 = [1, 2, 4] -> valid
// c2 = [2]


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        Set<List<Integer>> result = new HashSet<>();

        rec(target, 0, candidates, new ArrayList<>(),result);

        return result.stream().toList();
    }

    private void rec(int target, int i, int[] candidates, List<Integer> currentCombination, Set<List<Integer>> result) {
        if (target == 0 ) {
            // Found a valid combination
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        if (target < 0 || i == candidates.length) {
            // Invalid combination
            return;
        }

        // Recursive case
        for (int j = i; j < candidates.length; j++) {
            int cand = candidates[j];
            currentCombination.add(cand);
            rec(target - cand, j + 1, candidates, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);
        }

    }
}
