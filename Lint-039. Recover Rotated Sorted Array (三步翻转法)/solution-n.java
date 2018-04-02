public class Solution {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return ;
        }
        
        int i = 1;
        while (i < nums.size() && nums.get(i) >= nums.get(i - 1)) {
            i++;
        }
        
        if (i == nums.size()) {
            return ;
        }
        
        reverse(nums, i, nums.size() - 1);
        reverse(nums, 0, i - 1);    
        // now, the whole array is in reversed order
        reverse(nums, 0, nums.size() - 1);
    }
    
    public void reverse(List<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            
            start++;
            end--;
        }
    }
}