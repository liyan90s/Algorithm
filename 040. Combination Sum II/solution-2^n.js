/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
    if (candidates === null || candidates.length === 0) {
        return [];
    }
    
    candidates.sort();
    var results = [];
    backtrack(candidates, target, results, [], 0, 0);
    
    return results;
};

var backtrack = function(candidates, target, results, result, startIdx, sum) {
    if (sum > target) {
        return ;
    }
    
    if (sum === target) {
        results.push(result.slice());
        return ;
    }
    
    for (var i = startIdx; i < candidates.length; i++) {
        if (i > startIdx && candidates[i] === candidates[i - 1]) {
            continue ;
        }
        
        result.push(candidates[i]);
        backtrack(candidates, target, results, result, i + 1, sum + candidates[i]);
        result.pop();
    }
};