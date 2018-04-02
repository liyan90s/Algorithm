class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        
        int len = nums.length;
        int[] res = new int[len];
        
        for (int i = 0; i < len; i++) {
            res[i] = a * nums[i] * nums[i] + b * nums[i] + c;
        }
        
        Arrays.sort(res);
        
        return res;
    }
}