class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            if (h == height[left]) {
                while (left < right && height[left] <= h) {
                    res += h - height[left];
                    left++;
                }
            } else {
                while (right > left && height[right] <= h) {
                    res += h - height[right];
                    right--;
                }
            }
        }
        
        return res;
    }
}