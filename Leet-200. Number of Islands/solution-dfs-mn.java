// Time: O(m * n), Space: O(m * n)
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    count++;
                    dfs(i - 1, j, grid);
                    dfs(i, j - 1, grid);
                    dfs(i + 1, j, grid);
                    dfs(i, j + 1, grid);
                }
            }
        }
        
        return count;
    }
    
    public void dfs(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return ;
        }
        
        grid[row][col] = '0';
        dfs(row - 1, col, grid);
        dfs(row, col - 1, grid);
        dfs(row + 1, col, grid);
        dfs(row, col + 1, grid);
    }
}