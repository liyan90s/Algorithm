/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    if (s === null || t === null || s.length < t.length) {
        return '';
    }
    
    var map = {};
    for (var i = 0; i < t.length; i++) {
        map[t[i]] = map[t[i]] !== undefined ? map[t[i]] + 1 : 1;
    }
    
    var minLen = s.length + 1;
    var minStart = 0;
    var count = 0;
    var right = 0;
    
    for (var left = 0; left < s.length; left++) {
        while (right < s.length && count !== t.length) {
            if (map[s[right]] !== undefined) {
                map[s[right]]--;
                
                if (map[s[right]] >= 0) {
                    count++;
                }
            }
            
            right++;
        }
        
        if (count === t.length) {
            if (right - left < minLen) {
                minLen = right - left;
                minStart = left;
            }
        }
        
        if (map[s[left]] !== undefined) {
            map[s[left]]++;
            if (map[s[left]] > 0) {
                count--;
            }
        }        
    }
    
    return minLen > s.length ? '' : s.substring(minStart, minStart + minLen);
};