/**
 * @param {number} s
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function(s, nums) {
    if (s === null || nums === null) {
        return 0;
    }
    
    var sum = 0;
    var right = 0;
    var res = nums.length + 1;
    
    for (var left = 0; left < nums.length; left++) {
        while (right < nums.length && sum < s) {
            sum += nums[right];
            right++;
        }
        
        if (sum >= s) {
            res = Math.min(res, right - left);
        }
        
        sum -= nums[left];
    }
    
    return res > nums.length ? 0 : res;
};