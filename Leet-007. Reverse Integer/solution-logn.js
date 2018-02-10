/**
 * @param {number} x
 * @return {number}
 */

// Time: O(logN)
var reverse = function(x) {
    var max = Math.pow(2, 31) - 1;
    var min = Math.pow(-2, 31);
    
    if (x > max || x < min) return 0;
    
    var ret = 0;
    var isNeg = x < 0 ? true : false;
    x = Math.abs(x);
    
    while (x > 0) {
        var digit = x % 10;
        if (!isNeg && 10 * ret > max - digit) {
            return 0;
        } else if (isNeg && -10 * ret < min + digit) {
            return 0;
        } else {
            ret = 10 * ret + digit;
        }
        
        x = ~~(x / 10);
    }
    
    return isNeg ? -ret : ret;
};
