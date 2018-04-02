class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || k < 1) {
            return res;
        }
        
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        
        // build maxHeap
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if (freqMap.get(o1) != freqMap.get(o2)) {
                return freqMap.get(o2).compareTo(freqMap.get(o1));
            } else {
                return o1.compareTo(o2);
            }
        });
        
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            pq.offer(entry.getKey());
        }
        
        while (res.size() < k) {
            res.add(pq.poll());
        }
        
        return res;
    }
}