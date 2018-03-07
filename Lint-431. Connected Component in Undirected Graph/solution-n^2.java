/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

// Time: O(n^2), where n is the number of nodes

public class Solution {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        List<List<Integer>> res = new ArrayList<>();
        if (nodes == null || nodes.isEmpty()) {
            return res;
        }
        
        HashSet<Integer> set = new HashSet<>();
        for (UndirectedGraphNode node : nodes) {
            set.add(node.label);
        }
        
        UnionFind uf = new UnionFind(set);
        for (UndirectedGraphNode node : nodes) {
            for (UndirectedGraphNode neighbor : node.neighbors) {
                uf.union(node.label, neighbor.label);
            }
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int nodeLabel : set) {
            int rootLabel = uf.find(nodeLabel);
            if (!map.containsKey(rootLabel)) {
                List<Integer> list = new ArrayList<>();
                list.add(nodeLabel);
                map.put(rootLabel, list);
            } else {
                map.get(rootLabel).add(nodeLabel);
            }
        }
        
        for (int key : map.keySet()) {
            Collections.sort(map.get(key));
            res.add(map.get(key));
        }
        
        return res;
    }
    
    class UnionFind {
        Map<Integer, Integer> father;
        
        public UnionFind(HashSet<Integer> set) {
            father = new HashMap<>();
            
            for (int i : set) {
                father.put(i, i);
            }
        }
        
        public int find(int x) {
            int child = x;
            int parent = father.get(x);
            
            while (child != parent) {
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