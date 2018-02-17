class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int max = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            
            max = Math.max(max, findLargestRectangle(heights));
        }
        
        return max;
    }
    
    public int findLargestRectangle(int[] heights) {
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