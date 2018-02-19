/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

// Time: O(k), where k = operators.length
public class Solution {
    /*
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (n <= 0 || m <= 0 || operators == null || operators.length == 0) {
            return res;
        }
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] grid = new int[n][m];
        int count = 0;
        UnionFind uf = new UnionFind(n * m);
        for (Point point : operators) {
            int row = point.x;
            int col = point.y;
            
            if (grid[row][col] == 1) {
                res.add(count);
            } else {
                grid[row][col] = 1;
                count++;
                for (int i = 0; i < 4; i++) {
                    int nextRow = row + dirs[i][0];
                    int nextCol = col + dirs[i][1];
                    
                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && grid[nextRow][nextCol] == 1) {
                        count = uf.union(row * m + col, nextRow * m + nextCol, count);
                    }
                }
                
                res.add(count);
            }
        }
        
        return res;
    }
}

class UnionFind {
    int[] root;
    int[] rank;
    
    public UnionFind(int n) {
        root = new int[n];
        rank = new int[n];
        
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 0;
        }
    }
    
    public int find(int x) {
        if (root[x] != x) {
            root[x] = find(root[x]);
        }
        
        return root[x];
    }
    
    public int union(int a, int b, int count) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA != rootB) {
            if (rank[rootA] > rank[rootB]) {
                root[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]) {
                root[rootA] = rootB;
            } else {
                root[rootA] = rootB;
                rank[rootB]++;
            }
            
            count--;
        }
        
        return count;
    }
}