/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function(nums) {
    if (nums === null || nums.length < 2) {
        return ;
    }
    
    var i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) {
        i--;
    }
    
    if (i < 0) {
        reverse(nums, 0);
        return ;
    }
    
    var j = i + 1;
    while (j < nums.length && nums[j] > nums[i]) {
        j++;
    }
    j--;
    
    var temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
    
    reverse(nums, i + 1);
};

var reverse = function(nums, index) {
    var start = index;
    var end = nums.length - 1;
    
    while (start < end) {
        var temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        
        start++;
        end--;
    }
};