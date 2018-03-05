public class Solution {
    /*
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length != n - 1) {
            return false;
        }
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int top = q.poll();

            // check if already visted
            if (visited[top]) {
                return false;
            }
            
            visited[top] = true;
            for (int i : map.get(top)) {
                if (!visited[i]) {
                    q.add(i);
                }
            }
        }
        
        // check if all nodes are visited
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        
        return true;
    }
}