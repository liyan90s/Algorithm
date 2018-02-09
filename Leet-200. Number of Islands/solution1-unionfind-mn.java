class Solution {
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
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        int count = 0;
        UnionFind uf = new UnionFind(m * n);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    if (i > 0 && grid[i - 1][j] == '1') {
                        count = uf.union(i * n + j, (i - 1) * n + j, count);
                    }
                    
                    if (j > 0 && grid[i][j - 1] == '1') {
                        count = uf.union(i * n + j, i * n + j - 1, count);
                    }
                }
            }
        }
        
        return count;
    }
}