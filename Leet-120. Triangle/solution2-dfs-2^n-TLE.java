class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        
        return helper(triangle, 0, 0);
    }
    
    public int helper(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        
        int left = helper(triangle, row + 1, col);
        int right = helper(triangle, row + 1, col + 1);
        
        return Math.min(left, right) + triangle.get(row).get(col);
    }
}