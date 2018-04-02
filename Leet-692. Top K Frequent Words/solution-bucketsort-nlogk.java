class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || k < 1) {
            return res;
        }
        
        // build frequency map
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        // use bucket sort, coner case is that we need to let the length + 1
        List<String>[] buckets = new List[words.length + 1];
        for (String key : map.keySet()) {
            int freq = map.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        
        for (int i = buckets.length - 1; i > 0; i--) {
            if (res.size() >= k) {
                break ;
            }

            if (res.size() < k && buckets[i] != null) {
                Collections.sort(buckets[i]);
                // addAll can lead to res.size() > k
                // so need to truncate the res at the end, when it's gonna return
                res.addAll(buckets[i]);
            }
        }
        
        return res.size() == k ? res : res.subList(0, k);
    }
}