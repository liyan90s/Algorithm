// Time: O(nlogk), where n = total number of integers in the nums, k = nums.size()
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) {
            return new int[] {};
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.val, n2.val));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new Node(i, 0, nums.get(i).get(0)));
            max = Math.max(max, nums.get(i).get(0));
        }
        
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        int range = Integer.MAX_VALUE;
        while (pq.size() == nums.size()) {
            Node node = pq.poll();
            if (max - node.val < range) {
                range = max - node.val;
                start = node.val;
                end = max;
            } else if (max - node.val == range && node.val < start) { // never happen, but good to check here in the interview
                start = node.val;
                end = max;
            }
            
            if (node.index + 1 < nums.get(node.row).size()) {
                Node nextNode = new Node(node.row, node.index + 1, nums.get(node.row).get(node.index + 1));
                pq.offer(nextNode);
                if (nextNode.val > max) {
                    max = nextNode.val;
                }
            }
        }
        
        return new int[] {start, end};
    }
    
    class Node {
        int row, index, val;
        
        public Node(int row, int index, int val) {
            this.row = row;
            this.index = index;
            this.val = val;
        }
    }
}