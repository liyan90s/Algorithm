/**
 * @param {string} digits
 * @return {string[]}
 */

// Time: O(2^n)
var letterCombinations = function(digits) {
    if (digits === null || digits.length === 0) return [];
    for (var i = 0; i < digits.length; i++) {
        if (digits[i] < '2' || digits[i] > '9') return [];
    }
    
    var map = {
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz'
    }
    
    var ret = [];
    combinations(digits, map, ret, []);
    
    return ret;
}

var combinations = function(digits, map, results, result) {
    if (digits.length === 0) {
        results.push(result.join(''));
        return ;
    }
    
    var letters = map[digits[0]];
    for (var i = 0; i < letters.length; i++) {
        result.push(letters[i]);
        combinations(digits.substring(1), map, results, result);
        result.pop();
    }
};