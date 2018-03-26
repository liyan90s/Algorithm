class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[] {};
        }
        
        Arrays.sort(nums2);
        Set<Integer> intersect = new HashSet<>();
        for (int val : nums1) {
            if (binarySearch(nums2, val)) {
                intersect.add(val);
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
    
    public boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return nums[left] == target || nums[right] == target;
    }
}