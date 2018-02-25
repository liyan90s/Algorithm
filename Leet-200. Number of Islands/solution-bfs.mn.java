// Time: O(m * n), Space: O(2m) -> O(m)
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    
                    q.add(new int[] {i, j});
                    while (!q.isEmpty()) {
                        int[] idx = q.remove();
                        
                        for (int k = 0; k < 4; k++) {
                            int nextRow = idx[0] + dirs[k][0];
                            int nextCol = idx[1] + dirs[k][1];
                            
                            if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length && grid[nextRow][nextCol] == '1') {
                                grid[nextRow][nextCol] = '0';
                                q.add(new int[] {nextRow, nextCol});
                            }
                       }
                    }
                }
            }
        }
        
        return count;
    }
}