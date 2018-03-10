public class Solution {
    /*
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        
        int[] res = new int[nums.length];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i1 < i2 ? 1 : -1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            minHeap.add(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            
            res[i] = maxHeap.peek();
        }
        
        return res;
    }
}