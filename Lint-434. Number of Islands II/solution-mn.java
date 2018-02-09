/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */


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
        int count = 1;
        res.add(count);
        
        for (int i = 1; i < operators.length; i++) {
            Point currPoint = operators[i];
            count++;
            
            for (int j = 0; j < i; j++) {
                Point prevPoint = operators[j];
                
                if (Math.abs(currPoint.x - prevPoint.x) == 1 && currPoint.y == prevPoint.y) {
                    count = uf.union(currPoint.x * m + currPoint.y, prevPoint.x * m + prevPoint.y, count);
                }
                
                if (currPoint.x == prevPoint.x && Math.abs(currPoint.y - prevPoint.y) == 1) {
                    count = uf.union(currPoint.x * m + currPoint.y, prevPoint.x * m + prevPoint.y, count);
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