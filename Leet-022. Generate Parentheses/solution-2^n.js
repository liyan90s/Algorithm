/**
 * @param {number} n
 * @return {string[]}
 */

// Time: O(2^n)
var generateParenthesis = function(n) {
    if (n <= 0) return [];
    
    var results = [];
    helper(n, n, [], results);
    
    return results;
};

var helper = function(l, r, result, results) {
    if (l === 0 && r === 0) {
        results.push(result.join(''));
        return ;
    } 
    
    if (l > 0) {        
        result.push('(');
        helper(l - 1, r, result, results);
        result.pop();
    }
    
    if (r > l) {
        result.push(')');
        helper(l, r - 1, result, results);
        result.pop();
    }
};
