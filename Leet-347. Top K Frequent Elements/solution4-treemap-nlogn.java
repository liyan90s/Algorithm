class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k < 1) {
            return res;
        }
        
        // use hashtable to count each element's frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        // use TreeMap and use freqncy as the key so we can get all freqencies in order
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!freqMap.containsKey(entry.getValue())) {
                freqMap.put(entry.getValue(), new ArrayList<>());
            }
            freqMap.get(entry.getValue()).add(entry.getKey());
        }
        
        while (res.size() < k) {
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        
        return res;
    }
}