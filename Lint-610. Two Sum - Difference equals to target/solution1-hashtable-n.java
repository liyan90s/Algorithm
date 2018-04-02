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
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - target) || map.containsKey(nums[i] + target)) {
                int[] res = new int[2];
                res[0] = map.containsKey(nums[i] - target) ? map.get(nums[i] - target) + 1 : map.get(nums[i] + target) + 1;
                res[1] = i + 1;
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        
        return new int[] {};
    }
}