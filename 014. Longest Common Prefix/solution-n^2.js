/**
 * @param {string[]} strs
 * @return {string}
 */

// Time: O(m * n), where m is the longestLen
var longestCommonPrefix = function(strs) {
    if (strs === null || strs.length === 0) return "";
    
    var longestStr = strs[0];
    for (var i = 1; i < strs.length; i++) {
        for (var j = 0; j < longestStr.length; j++) {
            if (j >= strs[i].length || strs[i][j] != longestStr[j]) {
                longestStr = longestStr.substring(0, j);
                break;
            }            
        }
    }
    
    return longestStr;
};