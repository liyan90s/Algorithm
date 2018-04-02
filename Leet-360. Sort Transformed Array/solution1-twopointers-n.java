class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        
        int[] res = new int[nums.length];
        int index = a <= 0 ? 0 : nums.length - 1;
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int leftVal = quad(nums[left], a, b, c);
            int rightVal = quad(nums[right], a, b, c);
            
            if (a <= 0) {
                if (leftVal < rightVal) {
                    res[index] = leftVal;
                    left++;
                } else {
                    res[index] = rightVal;
                    right--;
                }
                
                index++;
            } else {
                if (leftVal < rightVal) {
                    res[index] = rightVal;
                    right--;
                } else {
                    res[index] = leftVal;
                    left++;
                }
                
                index--;
            }
        }
        
        return res;
    }
    
    public int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}