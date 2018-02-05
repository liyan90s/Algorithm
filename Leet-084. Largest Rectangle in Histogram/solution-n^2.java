class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            max = Math.max(max, heights[i]);
            for (int j = i + 1; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int area = minHeight * (j - i + 1);
                max = Math.max(max, area);
            }
        }
        
        return max;
    }
}