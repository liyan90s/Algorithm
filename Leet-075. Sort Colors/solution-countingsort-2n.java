class Solution {
    public void sortColors(int[] nums) {        
        if (nums == null || nums.length <= 1) {
            return ;
        }
        
        int[] colors = new int[3];          // for 3 colors
        for (int i = 0; i < nums.length; i++) {
            colors[nums[i]]++;
        }
        
        int colorIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            while (colors[colorIdx] == 0) {
                colorIdx++;
            }
            
            nums[i] = colorIdx;
            colors[colorIdx]--;
        }
    }
}