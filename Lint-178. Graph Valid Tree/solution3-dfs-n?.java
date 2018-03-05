public class Solution {
    /*
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        if (n < 0 || edges.length != n - 1) {
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
        // check circles
        if (!dfs(0, -1, map, visited)) {
            return false;
        }
        
        // check if all the nodes are connected
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(int curr, int parent, Map<Integer, ArrayList<Integer>> map, boolean[] visited) {
        if (visited[curr]) {
            return false;
        }
        
        visited[curr] = true;
        
        for (int i : map.get(curr)) {
            if (i != parent && !dfs(i, curr, map, visited)) {
                return false;
            }
        }
        
        return true;
    }
}