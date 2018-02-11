/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    if (haystack === null || needle === null || haystack.length < needle.length) {
        return -1;
    }
    
    if (haystack.length === 0) {
        return needle.length === 0 ? 0 : -1;
    }
    
    for (var i = 0; i < haystack.length - needle.length + 1; i++) {
        for (var j = 0; j < needle.length; j++) {
            if (haystack[i + j] !== needle[j]) {
                break ;
            }
        }
        
        if (j === needle.length) {
            return i;    
        }
    }
    
    return -1;
};