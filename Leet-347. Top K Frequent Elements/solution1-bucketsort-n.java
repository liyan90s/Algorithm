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
        
        // corner case: if there is only one number in nums, we need the bucket has index 1.
        // Note: the way for creating array of List
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        
        for (int i = buckets.length - 1; i > 0; i--) {
            if (res.size() < k && buckets[i] != null) {
                res.addAll(buckets[i]);
            }
        }
        
        return res.size() == k ? res : res.subList(0, k);
    }
}