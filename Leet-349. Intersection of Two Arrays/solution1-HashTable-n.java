// Time: O(n), Space: O(n)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[] {};
        }
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int val : nums1) {
            set1.add(val);
        }
        
        for (int val : nums2) {
            if (set1.contains(val)) {
                intersect.add(val);
            }
        }
        
        int[] res = new int[intersect.size()];
        int i = 0;
        for (int val : intersect) {
            res[i] = val;
            i++;
        }
        
        return res;
    }
}