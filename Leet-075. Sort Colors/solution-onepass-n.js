/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
    if (nums === null || nums.length < 2) {
        return ;
    }
    
    // 2 ptrs indicate the last idx of red sorted el and white sorted el respectively
    var idxRed = 0;
    var idxWhite = 0;
    
    for (var i = 0; i < nums.length; i++) {
        if (nums[i] === 0) {
            nums[i] = 2;
            nums[idxWhite++] = 1;
            nums[idxRed++] = 0;
        } else if (nums[i] === 1) {
            nums[i] = 2;
            nums[idxWhite++] = 1;
        }
    }
};