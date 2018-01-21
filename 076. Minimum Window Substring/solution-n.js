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
        if (!map[t[i]]) {
            map[t[i]] = 1;
        } else {
            map[t[i]]++;
        }
    }
    
    var minLen = s.length + 1;
    var minStart = 0;
    var count = 0;
    var left = 0;
    var right = 0;
    
    while (right < s.length) {
        if (map[s[right]] !== undefined) {
            map[s[right]]--;
            
            if (map[s[right]] >= 0) {
                count++;
            }
            
            while (count === t.length) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                if (map[s[left]] !== undefined) {
                    map[s[left]]++;
                    
                    if (map[s[left]] > 0) {
                        count--;
                    }
                }
                
                left++;
            }
        }
        right++;
    }
    
    if (minLen > s.length) {
        return '';
    }
    
    return s.substring(minStart, minStart + minLen);
};