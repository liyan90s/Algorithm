/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
    if (num < 1 || num > 3999) return 0;
    
    var vals = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
    var strs = ['M', 'CM', 'D', 'CD', 'C','XC', 'L', 'XL', 'X', 'IX', 'V', 'IV', 'I'];
    
    var ret = [];
    for (var i = 0; i < vals.length; i++) {
        while (num >= vals[i]) {
            ret.push(strs[i]);
            num -= vals[i];
        }
    }
    
    return ret.join('');
};