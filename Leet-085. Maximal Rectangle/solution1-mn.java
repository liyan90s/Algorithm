class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    heights[j] = matrix[0][j] - '0';
                } else {
                    heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
                }
            }
            
            maxArea = Math.max(maxArea, findLargest(heights));
        }
        
        return maxArea;
    }
    
    public int findLargest(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int w = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            max = Math.max(max, h * w);            
        }
        
        return max;
    }
}