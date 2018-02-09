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
        
        if (n <= 0 || m <= 0 || operators == null || operators.length == 0) {
            return new ArrayList<>();
        }
        
        List<Integer> res = new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);
        int[][] grid = new int[n][m];
        int count = 0;
        
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (Point p : operators) {
            int currX = p.x;
            int currY = p.y;
            
            if (grid[currX][currY] == 1) {
                res.add(count);
                continue ;
            }
            
            grid[currX][currY] = 1;
            count++;
            
            for (int i = 0; i < 4; i++) {
                int nextX = currX + dirs[i][0];
                int nextY = currY + dirs[i][1];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && grid[nextX][nextY] == 1) {
                    count = uf.union(currX * m + currY, nextX * m + nextY, count);
                }
            }
            
            res.add(count);
        }
        
        return res;
    }
    
    class UnionFind {
        int[] father;
        int[] rank;
        
        public UnionFind(int n) {
            father = new int[n];
            rank = new int[n];
            
            for (int i = 0; i < n; i++) {
                father[i] = i;
                rank[i] = 0;
            }
        }
        
        public int find(int x) {
            if (father[x] != x) {
                father[x] = find(father[x]);
            }
            
            return father[x];
        }
        
        public int union(int a, int b, int count) {
            int rootA = find(a);
            int rootB = find(b);
            
            if (rootA != rootB) {
                if (rank[rootA] > rank[rootB]) {
                    father[rootB] = rootA;
                } else if (rank[rootA] < rank[rootB]) {
                    father[rootA] = rootB;
                } else {
                    father[rootA] = rootB;
                    rank[rootB]++;
                }
                
                count--;
            }
            
            return count;
        }
    }
}
