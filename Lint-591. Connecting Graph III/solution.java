public class ConnectingGraph3 {
    int[] father;
    int count;
    /*
    * @param n: An integer
    */
    public ConnectingGraph3(int n) {
        // do intialization if necessary
        father = new int[n + 1];
        count = n;
        for (int i = 0; i <= n; i++) {
            father[i] = i;
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
            father[rootA] = rootB;
            count--;
        }
    }

    /*
     * @return: An integer
     */
    public int query() {
        // write your code here
        return count;
    }
}