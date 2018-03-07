/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

// Time: O(n^2), where n is the number of nodes
public class Solution {
    /*
     * @param nodes: a array of Directed graph node
     * @return: a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nodes == null || nodes.isEmpty()) {
            return res;
        }
        
        HashSet<Integer> nodeSet = new HashSet<>();
        for (DirectedGraphNode node : nodes) {
            nodeSet.add(node.label);
        }
        
        UnionFind uf = new UnionFind(nodeSet);
        for (DirectedGraphNode node : nodes) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                uf.union(node.label, neighbor.label);
            }
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int nodeLabel : nodeSet) {
            int rootLabel = uf.find(nodeLabel);
            if (!map.containsKey(rootLabel)) {
                List<Integer> l = new ArrayList<>();
                l.add(nodeLabel);
                map.put(rootLabel, l);
            } else {
                map.get(rootLabel).add(nodeLabel);
            }
        }
        
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
            res.add(list);
        }
        
        return res;
    }
    
    class UnionFind {
        Map<Integer, Integer> father;
        
        public UnionFind(HashSet<Integer> nodes) {
            father = new HashMap<>();
            for (int nodeLabel : nodes) {
                father.put(nodeLabel, nodeLabel);
            }
        }
        
        public int find(int x) {
            int parent = father.get(x);
            int child = x;
            
            while (parent != child) {
                child = parent;
                parent = father.get(parent);
            }
            
            return parent;
        }
        
        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                father.put(rootA, rootB);
            }
        }
    }
}