// Time: O(mlogn), where m = houses.length, n = heaters.length
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;
        
        for (int house : houses) {
            int pos = binarySearch(heaters, house);
            
            int distLeft = pos - 1 >= 0 ? house - heaters[pos - 1] : heaters[0] - house;
            int distRight = pos < heaters.length ? heaters[pos] - house : house - heaters[heaters.length - 1];
            
            res = Math.max(res, Math.min(distLeft, distRight));
        }
        
        return res;
    }
    
    public int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (target <= nums[start]) {
            return start;
        } else if (target <= nums[end]) {
            return end;
        } else {
            return end + 1;
        }
    }
}