/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */

// Time: O(n^2)
var threeSumClosest = function(nums, target) {
    if (nums === null || nums.length < 3) return Number.MAX_SAFE_INTEGER;
    
    nums.sort(function(a, b) {
        return a - b;
    });
    
    var ret = Number.MAX_SAFE_INTEGER;
    for (var i = 0; i < nums.length - 2; i++) {
        var lo = i + 1;
        var hi = nums.length - 1;
        while (lo < hi) {
            var sum = nums[i] + nums[lo] + nums[hi];
            if (sum === target) return target;
            
            if (Math.abs(target - sum) < Math.abs(target - ret)) {
                ret = sum;
            }
            
            if (sum > target) {
                hi--;
            } else {
                lo++;
            }
        }
    }
    
    return ret;
};