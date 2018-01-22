/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    if (nums === null || nums.length < 2) {
        return [nums];
    }
    
    var results = [[nums[0]]];
    
    for (var i = 1; i < nums.length; i++) {
        var newResults = [];
        for (var j = 0; j < results.length; j++) {
            for (var k = 0; k <= i; k++) {
                var permutation = results[j].slice();
                permutation.splice(k, 0, nums[i]);
                newResults.push(permutation);
            }
        }
        
        results = newResults;
    }
    
    return results;
};