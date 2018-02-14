/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
    if (nums === null || nums.length < 2) {
        return ;
    }
    
    var map = new Array(3).fill(0);             // since just 3 colors, arry.length is set to 3
    for (var i = 0; i < nums.length; i++) {
        map[nums[i]]++;
    }
    
    var mapIdx = 0;
    for (var i = 0; i < nums.length; i++) {
        while (map[mapIdx] === 0) {
            mapIdx++;
        }
        
        nums[i] = mapIdx;
        map[mapIdx]--;
    }
};