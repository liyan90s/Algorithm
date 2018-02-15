// TreeSet is a self-balancing binary search tree
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[] {};
        }
        
        TreeSet<Node> window = new TreeSet<Node>((o1, o2) -> o1.val != o2.val ? Integer.compare(o1.val, o2.val) : o1.idx - o2.idx);
        int[] result = new int[nums.length - k + 1];
        
        for (int i = 0; i < k - 1; i++) {
            add(window, new Node(i, nums[i]));
        }
        
        for (int i = k - 1; i < nums.length; i++) {
            add(window, new Node(i, nums[i]));
            result[i - k + 1] = window.last().val;
            remove(window, new Node(i - k + 1, nums[i - k + 1]));
        }
        
        return result;
    }
    
    public void add(TreeSet<Node> window, Node node) {
        window.add(node);
    }
    
    public void remove(TreeSet<Node> window, Node node) {
        window.remove(node);
    }
}

class Node {
    int idx, val;
    
    public Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}