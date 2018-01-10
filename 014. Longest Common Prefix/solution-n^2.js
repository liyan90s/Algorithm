/**
 * @param {string[]} strs
 * @return {string}
 */

// Time: O(m * n), where m is the longestLen
var longestCommonPrefix = function(strs) {
    if (strs === null || strs.length === 0) return "";
    
    var firstStr = strs[0];
    var longestLen = firstStr.length;
    
    for (var i = 1; i < strs.length; i++) {
        for (var j = 0; j < longestLen; j++) {
            if (j >= strs[i].length || strs[i][j] !== firstStr[j]) {
                break;
            }
        }
        longestLen = j;
    }
    
    return firstStr.substring(0, j);
};