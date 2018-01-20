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
    
    while (newDvd >= newDvs) {
        var temp = newDvs;
        var i = 0;
        while (newDvd >= temp << 1) {
            if (temp << 1 <= 0) {
                break ;
            }
            
            temp <<= 1;
            i++;
            
            if (!isNeg && i > 29) {
                return max;
            } else if (isNeg && i > 30) {
                return min;
            }
        }
        
        newDvd -= temp;
        res += 1 << i;
    }
    
    return isNeg ? -res : res;
};