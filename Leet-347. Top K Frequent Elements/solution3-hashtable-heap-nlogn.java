// Use Heap (PriorityQueue) to store HashTable (HashMap) !
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k < 1) {
            return res;
        }
        
        // use hashtable to count each element's frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int val : nums) {
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        }
        
        // build maxHeap using the Map.Entry<E, E> !!
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(entry);
        }
        
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            res.add(entry.getKey());
        }
        
        return res;
    }
}