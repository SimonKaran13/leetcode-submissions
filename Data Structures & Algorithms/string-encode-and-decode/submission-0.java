class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty() || str.isBlank()) return List.of();

        List<String> decodedList = new ArrayList<>();
        String currentStr = str;
        while (true) {
            if (currentStr.length() == 0) break;
            // Read Number until first separator
            int separatorIndex = currentStr.indexOf('#');
            String strLen = currentStr.substring(0, separatorIndex);
            int len = Integer.valueOf(strLen);
            String decodedStr = currentStr.substring(separatorIndex + 1, separatorIndex + len + 1);
            decodedList.add(decodedStr);
            currentStr = currentStr.substring(separatorIndex + len + 1);
        }
        return decodedList;
    }
}

// 2#hi2#no