class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] heights = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    heights[i][j] = matrix[i][j] - '0';
                } else if (matrix[i][j] == '1') {
                    heights[i][j] = heights[i - 1][j] + 1;
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < m; i++) {
            int rowMax = findLargestRectangle(heights[i]);
            max = Math.max(max, rowMax);
        }
        
        return max;
    }
    
    public int findLargestRectangle(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int currHeight = i == heights.length ? -1 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= currHeight) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        
        return max;
    }
}