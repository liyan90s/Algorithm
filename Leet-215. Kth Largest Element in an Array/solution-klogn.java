class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return Integer.MIN_VALUE;
        }
        
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        
        int count = 0;
        while (!pq.isEmpty()) {
            int val = pq.poll();
            count++;
            if (count == k) {
                return val;
            }
        }
        
        return Integer.MIN_VALUE;
    }
}