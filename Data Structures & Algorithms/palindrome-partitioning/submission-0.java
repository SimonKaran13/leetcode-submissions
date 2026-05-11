class Solution {
    private List<List<String>> result; 

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();

        List<String> partition = new ArrayList<>();
        rec(s, 0, partition);

        return result;
    }


    private void rec(String s, int i, List<String> partition) {
        if (i >= s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                partition.add(s.substring(i, j + 1));
                rec(s, j + 1, partition);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
