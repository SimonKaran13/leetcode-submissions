class Solution {
    public int largestRectangleArea(int[] heights) {
        // return bruteForce(heights);
        int maxA = 0;
        Stack<List<Integer>> stack = new Stack<>(); // Stack<(Idx, Height)>

        for (int i = 0; i < heights.length; i++) {

            int startIdx = i;
            
            while (!stack.isEmpty() && stack.peek().get(1) > heights[i]) {
                List<Integer> popped = stack.pop();
                int prevHeight = popped.get(1);
                int prevIdx = popped.get(0);
                
                int area = prevHeight * (i - prevIdx);
                
                maxA = Math.max(area, maxA);
                
                startIdx = prevIdx; // Update width

            }

            stack.push(List.of(startIdx, heights[i]));
        }

        while (!stack.isEmpty()) {
            List<Integer> popped = stack.pop();
            int prevHeight = popped.get(1);
            int prevIdx = popped.get(0);
            int area = prevHeight * (heights.length - prevIdx);
            maxA = Math.max(area, maxA);
        }

        return maxA;
    }

    private int bruteForce(int[] heights) {
        int maxA = 0;
    
        for (int j = 0; j < heights.length; j++) {
            for (int i = 0; i < heights.length; i++) {
                int[] subArray = Arrays.copyOfRange(heights, j, j + i + 1);
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
