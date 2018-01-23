/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
    if (n < 0 || k < 0 || n < k) {
        return [];
    }
    
    var results = [];
    backtrack(n, k, results, [], 1);
    
    return results;
};

var backtrack = function(n, k, results, result, startNum) {
    if (result.length === k) {
        results.push(result.slice());
        return ;
    }
    
    for (var i = startNum; i <= n; i++) {
        result.push(i);
        backtrack(n, k, results, result, i + 1);
        result.pop();
    }
};