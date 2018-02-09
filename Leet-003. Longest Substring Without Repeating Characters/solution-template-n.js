/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    if (s === null || s.length === 0) {
        return 0;
    }
    
    var map = {};
    var maxLen = 0;
    var right = 0;
    
    for (var left = 0; left < s.length; left++) {
        while (right < s.length && !map[s[right]]) {
            map[s[right]] = true;
            right++;
        }
        
        if (right === s.length || map[s[right]]) {
            maxLen = Math.max(maxLen, right - left);
        }
        
        if (map[s[left]] != undefined) {
            map[s[left]] = false;
        }
    }
    
    return maxLen;
};