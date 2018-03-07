/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nodes == null || nodes.isEmpty()) {
            return res;
        }
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (UndirectedGraphNode node : nodes) {
            if (!visited.contains(node.label)) {
                List<Integer> list = new ArrayList<>();
                queue.add(node);
                while (!queue.isEmpty()) {
                    UndirectedGraphNode topNode = queue.poll();
                    if (!visited.contains(topNode.label)) {
                        list.add(topNode.label);
                        visited.add(topNode.label);
                        for (UndirectedGraphNode neighbor : topNode.neighbors) {
                            queue.add(neighbor);
                        }
                    }
                }
                
                Collections.sort(list);
                res.add(list);
            }
        }
        
        return res;
    }
}