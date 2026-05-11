class Solution {
    public String reorganizeString(String s) {
        if (s.length() == 1) return s;

        Map<Character, Integer> counter = new HashMap<>();
        int highestCount = 0;
        char highestChar = '0';

        char[] chars = s.toCharArray();
        for (char c : chars) {
            int count = counter.getOrDefault(c, 0) + 1;
            counter.put(c, count);
            if (count > highestCount) {
                highestCount = count;
                highestChar = c;
            }
        }
        if (s.length() % 2 == 0 ? highestCount > s.length() / 2 : highestCount > (s.length() / 2) + 1) {
            return "";
        }   

        StringBuilder sb = new StringBuilder();
 

        while (!counter.isEmpty()) {
            highestChar = maxChar(counter);
            sb.append(highestChar);
            decreaseCounter(highestChar, counter);
            Set<Character> currentKeys = new HashSet<>();
            currentKeys.addAll(counter.keySet());
            for (char c : currentKeys) {
                if (c == highestChar) continue;
                sb.append(c);
                decreaseCounter(c, counter);
                break;
            }
        }

        return sb.toString();
    }

    private void decreaseCounter(char c, Map<Character, Integer> counter) {
        if (!counter.containsKey(c)) return;
        if (counter.get(c) <= 1) {
            counter.remove(c);
        } else {
            counter.put(c, counter.get(c) - 1);
        }
    }

    private char maxChar(Map<Character, Integer> counter) {
        int max = 0;
        char c = '0';
        
        for (var entry : counter.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                c = entry.getKey();
            }
        }
        return c;
    }
}