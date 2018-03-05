public class ConnectingGraph2 {
    int[] father;
    int[] rank;
    /*
    * @param n: An integer
    */
    public ConnectingGraph2(int n) {
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
            father[rootB] = rootA;
            rank[rootA] += rank[rootB];
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        int rootA = find(a);
        return rank[rootA];
    }
}