class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeSet<Node> maxHeap = new TreeSet<>();
        TreeSet<Node> minHeap = new TreeSet<>();
        ArrayList<Double> result = new ArrayList<>();
                
        int half = (k + 1) / 2;
        for (int i = 0; i < k - 1; i++) {
            add(maxHeap, minHeap, half, new Node(i, nums[i]));
        }
        
        for (int i = k - 1; i < nums.length; i++) {
            add(maxHeap, minHeap, half, new Node(i, nums[i]));
            if (k % 2 == 0) {
                result.add(((double) maxHeap.last().val + minHeap.first().val) / 2.0);
            } else {
                result.add((double) maxHeap.last().val);
            }
            remove(maxHeap, minHeap, new Node(i - k + 1, nums[i - k + 1]));
        }
        
        double[] res = new double[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        
        return res;
    }
    
    public void add(TreeSet<Node> maxHeap, TreeSet<Node> minHeap, int size, Node node) {
        // Balancing the tree
        maxHeap.add(node);
        minHeap.add(maxHeap.pollLast());
        
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.pollFirst());
        }       
    }
    
    public void remove(TreeSet<Node> maxHeap, TreeSet<Node> minHeap, Node node) {
        if (maxHeap.contains(node)) {
            maxHeap.remove(node);            
        } else {
            minHeap.remove(node);
        }
    }
}

class Node implements Comparable<Node> {
    int id, val;
    public Node(int id, int val) {
        this.id = id;
        this.val = val;
    }
    
    @Override
    public int compareTo(Node that) {
        if (this.val != that.val) {
            return this.val < that.val ? -1 : 1;
        } else {
            return this.id - that.id;
        }
    }
}