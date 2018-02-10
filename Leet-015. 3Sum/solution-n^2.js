/**
 * @param {number[]} nums
 * @return {number[][]}
 */

// Time: O(n^2)
var threeSum = function(nums) {
    if (nums === null || nums.length < 3) return [];
    
    nums.sort(function(a, b) {
        return a - b;
    });
    
    var ret = [];
    for (var i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] === nums[i - 1]) continue;
        
        var lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] + nums[hi] === 0 - nums[i]) {
                ret.push([nums[i], nums[lo], nums[hi]]);
                while (lo < hi && nums[lo] === nums[lo + 1]) lo++;
                while (lo < hi && nums[hi] === nums[hi - 1]) hi--;
                lo++;
                hi--;
            } else if (nums[lo] + nums[hi] > 0 - nums[i]) {
                hi--;
            } else {
                lo++;
            }
        }
    }
    
    return ret;
};