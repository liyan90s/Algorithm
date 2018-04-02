// when the input array is sorted, we can use two pointers
public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[] {};
        }
        
        int right = 1;
        for (int left = 0; left < nums.length; left++) {
            while (right < nums.length && nums[right] - nums[left] < target) {
                right++;
            }
            
            if (right < nums.length && nums[right] - nums[left] == target) {
                int[] res = new int[2];
                res[0] = nums[left];
                res[1] = nums[right];
            }
        }
        
        return new int[] {};
    }
}