/**
 * @param {number} x
 * @return {boolean}
 */

// Time: O(n)
var isPalindrome = function(x) {
    if (x < 0) return false;
    if (x < 10) return true;
    
    var div = 1;
    while (10 * div <= x) {
        div *= 10;
    }
    
    while (x > 0) {
        var l = ~~(x / div);
        var r = x % 10;
        if (l != r) return false;
        
        x = ~~((x % div) / 10);
        div = ~~(div / 100);
    }
    
    return true;
};
