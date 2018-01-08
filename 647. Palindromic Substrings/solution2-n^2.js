/**
 * @param {string} s
 * @return {number}
 */

// Time: O(n^2), Space: O(n^2)
var countSubstrings = function(s) {
    if (s === null || s.length <= 1) return s.length;
    
    var ret = 0;
    var len = s.length;
    var dict = new Array(len);
    for (var i = 0; i < len; i++) {
        dict[i] = new Array(len).fill(false);
    }
    
    for (var i = len - 1; i >= 0; i--) {
        dict[i][i] = true;
        for (var j = i + 1; j < len; j++) {
            if (s[i] === s[j] && (j - i <= 1 || dict[i + 1][j - 1])) {
                dict[i][j] = true;
            }
        }
    }
    
    for (var i = 0; i < len ; i++) {
        for (var j = 0; j < len; j++) {
            if (dict[i][j]) {
                ret++;
            }
        }
    }
    
    return ret;
};
