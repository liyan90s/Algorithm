class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 1;
        map.put(nums[left], 1);
        
        while (right < nums.length) {
            // TODO: combine the two if checks into one
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
                map.put(nums[left], 1);
            } else if (map.get(nums[left]) < 2) {
                left++;
                nums[left] = nums[right];
                map.put(nums[left], map.get(nums[left]) + 1);
            }
            
            right++;
        }
        
        return left + 1;
    }
}