// Sort the width in ascending order, when width is tie, sort the height in descending order;
// Now it's the LIS problem: Leet-300
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        
        Arrays.sort(envelopes, (e1, e2) -> {
            if (e1[0] != e2[0]) {
                return Integer.compare(e1[0], e2[0]);
            } else {
                return Integer.compare(e2[1], e1[1]);
            }
        });
        
        int[] memo = new int[envelopes.length];
        memo[0] = envelopes[0][1];
        int len = 1;
        
        for (int i = 1; i < envelopes.length; i++) {
            int insertPos = binarySearch(memo, len, envelopes[i][1]);
            memo[insertPos] = envelopes[i][1];
            
            if (insertPos == len) {
                len++;
            }
        }
        
        return len;
    }
    
    public int binarySearch(int[] nums, int len, int target) {
        int left = 0, right = len - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (target <= nums[left]) {
            return left;
        } else if (target <= nums[right]) {
            return right;
        } else {
            return right + 1;
        }
    }
}