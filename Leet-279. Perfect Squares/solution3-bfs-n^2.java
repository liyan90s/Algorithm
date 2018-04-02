class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        
        // when use bfs to search graph, Queue & Set should be standard
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> used = new HashSet<>();    // prevent circle
        q.add(0);        
        used.add(0);

        int step = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                
                // find neighbors to check if neighbor is "n"
                for (int j = 1; j * j <= n; j++) {
                    int neighbor = node + j * j;
                    
                    if (neighbor > n) {
                        break ;
                    } else if (neighbor == n) {
                        return step;
                    } else if (used.contains(neighbor)) {
                        continue ;
                    } else {
                        q.add(neighbor);
                        used.add(neighbor);
                    }
                }
            }
        }
        
        return -1;
    }
}