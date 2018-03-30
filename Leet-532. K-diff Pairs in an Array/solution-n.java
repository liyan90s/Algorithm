class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) {
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        int res = 0;
        for (int key : map.keySet()) {
            if (k == 0) {
                if (map.get(key) >= 2) {
                    res++;
                }
            } else {
                if (map.containsKey(key + k)) {
                    res++;
                }
            }
        }
        
        return res;
    }
}