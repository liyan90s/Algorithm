/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
var divide = function(dividend, divisor) {
    var max = Math.pow(2, 31) - 1;
    var min = Math.pow(-2, 31);
    var isNeg = false;
    
    if (divisor === 0) {
        return dividend > 0 ? max : min;
    }
    
    if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
        isNeg = true;
    }
    
    var res = 0;
    var newDvd = Math.abs(dividend);
    var newDvs = Math.abs(divisor);
    var i = 0;
    
    while (newDvs << (i + 1) > 0 && newDvs << (i + 1) <= newDvd) {
        i++;
    }
    
    while (newDvd >= newDvs && i >= 0) {
        if (newDvd >= newDvs << i) {
            newDvd -= newDvs << i;
            res += 1 << i;
        }
        i--;
    }
    
    return isNeg ? -res : res;
};