class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxA = 0;
    
        for (int j = 0; j < heights.length; j++) {
            for (int i = 0; i < heights.length; i++) {
                int[] subArray = Arrays.copyOfRange(heights, j, j + i + 1);
                System.out.println("i: " + i + ", j: " + j);
                System.out.println(Arrays.toString(subArray));
                maxA = Math.max(maxA, maxAreaSubArray(subArray));
            }
        }

        return maxA;
    }


    private int maxAreaSubArray(int[] heights) {
        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < heights.length; i++) {
            minHeight = Math.min(minHeight, heights[i]);
        }
        return minHeight * heights.length;
    }


}
