/**
 * @param {number[]} nums
 * @return {number}
 */
var triangleNumber = function(nums) {
    if (nums === null || nums.length < 3) {
        return 0;
    }

    nums.sort(function(a, b) {
        return a - b;
    });
    
    var res = 0;

    for (var i = nums.length - 1; i >= 2; i--) {
        var left = 0;
        var right = i - 1;
        while (left < right) {
            if (nums[left] + nums[right] > nums[i]) {
                res += right - left;
                right--;
            } else {
               left++; 
            }
        }
    }

    return res;
};