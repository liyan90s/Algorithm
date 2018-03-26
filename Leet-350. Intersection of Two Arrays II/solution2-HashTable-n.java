// Time: O(n), Space: O(n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[] {};
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums1) {
            map.put(val, map.containsKey(val) ? map.get(val) + 1 : 1);
        }
        
        List<Integer> intersect = new ArrayList<>();
        for (int val : nums2) {
            if (map.containsKey(val) && map.get(val) > 0) {
                intersect.add(val);
                map.put(val, map.get(val) - 1);
            }
        }
        
        int[] res = new int[intersect.size()];
        int k = 0;
        for (int val : intersect) {
            res[k] = val;
            k++;
        }
        
        return res;
    }
}