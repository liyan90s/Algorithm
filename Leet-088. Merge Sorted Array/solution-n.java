class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null) {
            return ;
        }
        
        int idxM = m + n - 1;
        int idx1 = m - 1;
        int idx2 = n - 1;
        
        while (idx1 >= 0 && idx2 >= 0) {
            if (nums1[idx1] > nums2[idx2]) {
                nums1[idxM] = nums1[idx1];
                idx1--;
            } else {
                nums1[idxM] = nums2[idx2];
                idx2--;
            }
            idxM--;
        }
        
        while (idx2 >= 0) {
            nums1[idxM] = nums2[idx2];
            idx2--;
            idxM--;
        }
    }
}