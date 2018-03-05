public class Solution {
    /*
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n < 0 || edges.length != n - 1) {
            return false;
        }
        
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (!uf.connect(edge[0], edge[1])) {
                return false;
            }
        }
        
        return true;
    }
}

class UnionFind {
    int[] father;
    int[] rank;
    
    public UnionFind(int n) {
        father = new int[n];
        rank = new int[n];
        
        for (int i = 0; i < n; i++) {
            father[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x) {
        if (father[x] != x) {
            father[x] = find(father[x]);
        }
        
        return father[x];
    }
    
    public boolean connect(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA != rootB) {
            if (rank[rootA] < rank[rootB]) {
                father[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                father[rootB] = rootA;
            } else {
                father[rootB] = rootA;
                rank[rootA]++;
            }
            return true;
        } else {
            return false;
        }
    }
}