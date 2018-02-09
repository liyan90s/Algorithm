class Solution {
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
                }
            }
        }
        uf.setCount(count);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.union(i * n + j, (i - 1) * n + j);
                    } 
                    
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        uf.union(i * n + j, i * n + j - 1);
                    }
                }
            }
        }
        
        return uf.getCount();
    }
    
    class UnionFind {
        int[] father;
        int[] rank;
        int count;
        
        public UnionFind(int n) {
            father = new int[n];
            rank = new int[n];
            count = 0;
            
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
        
        public int find(int x) {
            if (father[x] != x) {
                father[x] = find(father[x]);
            }
            return father[x];
        }
        
        public void union(int a, int b) {
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
        }
        
        public int getCount() {
            return count;
        }
        
        public void setCount(int count) {
            this.count = count;
        }
    }
}