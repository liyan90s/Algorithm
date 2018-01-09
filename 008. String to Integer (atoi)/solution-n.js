/**
 * @param {string} str
 * @return {number}
 */

// Time: O(n)
var myAtoi = function(str) {
    if (str === null || str.length === 0) return 0;
    
    var max = 2147483647;
    var min = -2147483648;
    
    str = str.trim();
    
    var isNeg = false;
    var idx = 0;
    if (str[0] === '-' || str[0] === '+') {
        idx = 1;
        isNeg = str[0] === '-' ? true : false;
    }
    
    var ret = 0;
    for (var i = idx; i < str.length; i++) {
        var ch = str[i];
        if (ch < '0' || ch > '9') {
            break;
        }
        
        var digit = ch - '0';
        if (!isNeg && 10 * ret > max - digit) {
            return max;
        } else if (isNeg && -10 * ret < min + digit) {
            return min;
        }
        
        ret = 10 * ret + digit;
    }
    
    return isNeg ? -ret : ret;
};
