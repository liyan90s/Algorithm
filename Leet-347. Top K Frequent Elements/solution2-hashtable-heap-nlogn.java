class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k < 1) {
            return res;
        }
        
        // build frequency hashtable
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int val : nums) {
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        }
        
        // build maxHeap
        // use the hashtable information for the comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> freqMap.get(o2).compareTo(freqMap.get(o1)));
        
        for (int key : freqMap.keySet()) {
            pq.offer(key);
        }
        
        while (res.size() < k) {
            res.add(pq.poll());
        }
        
        return res;
    }
}