class Solution {
    public int maxArea(int[] heights) {
        /*
            Area is calculated by calculating min(heights[i], heights[j]) * abs(i - j)
            [1,1,1,8,1,1,1,1,8, 2, 3, 4]
            [1 - 1] = 8
            [2 - 2] = 12
            [3 - 3] = 12
        */
        int l = 0;
        int r = heights.length - 1;

        int maxArea = 0;
        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * Math.abs(l - r);
            if (area > maxArea) maxArea = area;

            if (heights[l] == heights[r]) {
                l++; r--;
            } else if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }
}
