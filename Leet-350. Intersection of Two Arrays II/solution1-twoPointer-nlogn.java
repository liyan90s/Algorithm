class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[] {};
        }
        
        List<Integer> intersect = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                intersect.add(nums1[i]);
                i++;
                j++;
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