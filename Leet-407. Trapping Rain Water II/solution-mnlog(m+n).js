// Time: O(m * n * log(m + n)), where m = heightMap.length, n = heightMap[0].length
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int res = 0;
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return res;
        }
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });
        
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            used[i][0] = true;
            used[i][n - 1] = true;
        }
        
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            used[0][j] = true;
            used[m - 1][j] = true;
        }
        
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int k = 0; k < 4; k++) {
                int nextRow = cell.row + dirs[k][0];
                int nextCol = cell.col + dirs[k][1];
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !used[nextRow][nextCol]) {
                    used[nextRow][nextCol] = true;
                    res += Math.max(0, cell.height - heightMap[nextRow][nextCol]);
                    pq.offer(new Cell(nextRow, nextCol, Math.max(cell.height, heightMap[nextRow][nextCol])));
                }
            }
        }
        
        return res;
    }
}

class Cell {
    int row, col, height;
    public Cell(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}