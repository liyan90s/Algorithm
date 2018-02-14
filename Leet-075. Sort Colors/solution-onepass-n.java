class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        
        int i0 = 0, i1 = 0, i2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i2 > i0) {
                    nums[i2] = 2;
                } 
                
                if (i1 > i0) {
                    nums[i1] = 1;
                }
                
                nums[i0] = 0;
                
                i0++;
                i1++;
                i2++;
            } else if (nums[i] == 1) {
                if (i2 > i1) {
                    nums[i2] = 2;
                }
                
                nums[i1] = 1;
                
                i1++;
                i2++;
            } else {
                nums[i2] = 2;
                
                i2++;
            }
        }
    }
}