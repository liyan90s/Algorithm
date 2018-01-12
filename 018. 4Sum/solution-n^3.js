/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function(nums, target) {
    if (nums === null || nums.length < 4) return [];
    
    nums.sort(function(a, b) { 
        return a - b;
    });
    
    var ret = [];
    for (var i = 0; i < nums.length - 3; i++) {
        if (i > 0 && nums[i] === nums[i - 1]) continue;
        for (var j = i + 1; j < nums.length - 2; j++) {
            if (j > i + 1 && nums[j] === nums[j - 1]) continue;
            
            var lo = j + 1;
            var hi = nums.length - 1;
            while (lo < hi) {
                var sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                if (sum === target) {
                    ret.push([nums[i], nums[j], nums[lo], nums[hi]]);
                    lo++;
                    hi--;
                    while (lo < hi && nums[lo] === nums[lo - 1]) lo++;
                    while (lo < hi && nums[hi] === nums[hi + 1]) hi--;
                } else if (sum > target) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
    }
    
    return ret;
};