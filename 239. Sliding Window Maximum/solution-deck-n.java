class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[] {};
        }
        
        Deque<Integer> deck = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!deck.isEmpty() && deck.peek() < i - k + 1) {
                deck.poll();
            }
            
            while (!deck.isEmpty() && nums[deck.peekLast()] < nums[i]) {
                deck.pollLast();
            }
            
            deck.add(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[deck.peek()];
            }
        }
        
        return result;
    }
}