class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new double[] {};
        }
        
        double[] result = new double[nums.length - k + 1];
        TreeSet<Node> left = new TreeSet<>();
        TreeSet<Node> right = new TreeSet<>();
        
        for (int i = 0; i < k - 1; i++) {
            add(left, right, new Node(i, nums[i]));
        }
        
        for (int i = k - 1; i < nums.length; i++) {
            add(left, right, new Node(i, nums[i]));
            if (k % 2 == 0) {
                result[i - k + 1] = ((double) left.last().val + (double) right.first().val) / 2.0;
            } else {
                result[i - k + 1] = (double) left.last().val;
            }
            remove(left, right, new Node(i - k + 1, nums[i - k + 1]));
        }
        
        return result;
    }
    
    public void add(TreeSet<Node> left, TreeSet<Node> right, Node node) {
        left.add(node);
        right.add(left.pollLast());
        
        if (left.size() < right.size()) {
            left.add(right.pollFirst());
        }
    }
    
    public void remove(TreeSet<Node> left, TreeSet<Node> right, Node node) {
        if (left.contains(node)) {
            left.remove(node);
        } else {
            right.remove(node);
        }
    }
}

class Node implements Comparable<Node> {
    int idx, val;
    public Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
    
    @Override
    public int compareTo(Node that) {
        if (this.val != that.val) {
            return this.val > that.val ? 1 : -1;
        } else {
            return this.idx - that.idx;
        }
    }
}