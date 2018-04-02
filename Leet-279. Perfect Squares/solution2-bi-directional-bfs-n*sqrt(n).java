class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        
        // queue from the start-node to end-node
        Queue<Integer> startQueue = new LinkedList<>();
        Set<Integer> startVisited = new HashSet<>();
        startQueue.add(0);
        startVisited.add(0);
        
        // queue from the end-node to start-node
        Queue<Integer> endQueue = new LinkedList<>();
        Set<Integer> endVisited = new HashSet<>();
        endQueue.add(n);
        endVisited.add(n);
        
        int step = 0;
        
        while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
            int startSize = startQueue.size();
            int endSize = endQueue.size();
            
            // one step from the startQueue
            step++;
            
            for (int i = 0; i < startSize; i++) {
                int node = startQueue.poll();
                
                // check all current node's neighbor to see if 
                // one of them is visited from the endQueue.
                for (int j = 1; j * j <= n; j++) {
                    int neighbor = node + j * j;
                    
                    if (neighbor > n) {
                        break ;
                    } else if (startVisited.contains(neighbor)) { // already visited from the startQueue
                        continue ;
                    } else if (endVisited.contains(neighbor)) {  // endQueue has visited this neighbor, just return step
                        return step;
                    } else {
                        startQueue.add(neighbor);
                        startVisited.add(neighbor);
                    }
                }
            }
            
            // one step from the endQueue
            step++;
            
            for (int i = 0; i < endSize; i++) {
                int node = endQueue.poll();
                
                // check all current node's neighbor to see if 
                // one of them is visited from the startQueue.                
                for (int j = 1; j * j <= n; j++) {
                    int neighbor = node - j * j;
                    
                    if (neighbor < 0) {
                        break ;
                    } else if (endVisited.contains(neighbor)) { // already visited from the endQueue
                        continue ;
                    } else if (startVisited.contains(neighbor)) {   // startQueue has visited this neighbor, return step
                        return step;
                    } else {
                        endQueue.add(neighbor);
                        endVisited.add(neighbor);
                    }
                }
            }
        }
        
        return -1;      // nothing found (in this problem, never happen!)
    }
}