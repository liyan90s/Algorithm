class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }
        
        int len = nums1.length + nums2.length;
        
        if (len % 2 == 0) {
            return (findKthLargest(nums1, 0, nums2, 0, len / 2) + findKthLargest(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        } else {
            return (double) findKthLargest(nums1, 0, nums2, 0, len / 2 + 1);
        }
    }
    
    public int findKthLargest(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        } 
        
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        
        // -1 because index start from 0
        int mid = k / 2 - 1;
        
        if (start1 + mid >= nums1.length) {
            return findKthLargest(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        } else if (start2 + mid >= nums2.length) {
            return findKthLargest(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else if (nums1[start1 + mid] < nums2[start2 + mid]) {
            return findKthLargest(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return findKthLargest(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }
}