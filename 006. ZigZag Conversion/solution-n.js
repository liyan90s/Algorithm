/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */

// Time: O(n), Space: O(1)
var convert = function(s, numRows) {
    if (s === null || s.length <= 1 || numRows <= 1) return s;
    
    var sb = new Array(numRows).fill('');
    var rowIdx = 0, nextStep = 1;
    
    for (var i = 0; i < s.length; i++) {
        sb[rowIdx] += s[i];
        
        if (rowIdx === 0) {
            nextStep = 1
        } else if (rowIdx === numRows - 1) {
            nextStep = -1; 
        }
        
        rowIdx += nextStep;
    }
    
    return sb.join('');
};
