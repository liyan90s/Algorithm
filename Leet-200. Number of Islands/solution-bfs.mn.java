// Time: O(m * n), Space: O(2m) -> O(m)
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        int count = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;                                        
                    grid[i][j] = '0';                    
                    queue.offer(new Integer[] {i, j});
                    
                    while (!queue.isEmpty()) {
                        Integer[] idx = queue.poll();
                        int row = idx[0], col = idx[1];                        
                        
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            queue.offer(new Integer[] {row - 1, col});
                            grid[row - 1][col] = '0';
                        }
                        
                        if (row + 1 < m && grid[row + 1][col] == '1') {
                            queue.offer(new Integer[] {row + 1, col});
                            grid[row + 1][col] = '0';
                        }
                        
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            queue.offer(new Integer[] {row, col - 1});
                            grid[row][col - 1] = '0';
                        }
                        
                        if (col + 1 < n && grid[row][col + 1] == '1') {
                            queue.offer(new Integer[] {row, col + 1});
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        
        return count;
    }
}