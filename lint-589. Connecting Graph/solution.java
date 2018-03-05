public class ConnectingGraph {
    int[] father;
    int[] rank;
    
    /*
    * @param n: An integer
    */
    public ConnectingGraph(int n) {
        // do intialization if necessary
        father = new int[n + 1];
        rank = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
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

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
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
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here
        return find(a) == find(b);
    }
}