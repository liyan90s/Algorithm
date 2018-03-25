// Time: O(n), Space: O(n)
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int val : nums) {
            if (set.contains(val)) {
                return val;
            } else {
                set.add(val);
            }
        }
        
        return 0;
    }
}