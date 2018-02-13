/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function(s) {
    if (s === null || s.length === 0) {
        return [];
    }
    
    var results = [];
    backtrack(s, results, [], 0);
    
    return results;
};

var backtrack = function(s, results, result, startIdx) {
    if (startIdx === s.length) {
        results.push(result.slice());
        return ;
    }
    
    for (var i = startIdx; i < s.length; i++) {
        var substr = s.substring(startIdx, i + 1);
        if (isPalindrome(substr)) {
            result.push(substr);
            backtrack(s, results, result, i + 1);
            result.pop();
        }
    }
};

var isPalindrome = function(str) {
    var left = 0;
    var right = str.length - 1;
    
    while (left < right) {
        if (str[left] !== str[right]) {
            return false;
        }
        
        left++;
        right--;
    }
    
    return true;
};