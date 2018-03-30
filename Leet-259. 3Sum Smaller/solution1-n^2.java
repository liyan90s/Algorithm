class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (3 * nums[i] >= target) {
                break ;
            }
            
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum >= target) {
                    k--;
                } else {
                    res += k - j;
                    j++;
                }
            }
        }
        
        return res;
    }
}