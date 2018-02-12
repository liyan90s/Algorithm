/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */

// Template version
var checkInclusion = function(s1, s2) {
    if (s1 === null || s2 === null || s1.length > s2.length) {
        return false;
    }
    
    var map = {};
    for (var i = 0; i < s1.length; i++) {
        map[s1[i]] = map[s1[i]] === undefined ? 1 : map[s1[i]] + 1;
    }
    
    var left = 0;
    var count = 0;
    for (var right = 0; right < s2.length; right++) {
        if (map[s2[right]] !== undefined) {
            map[s2[right]]--;
            
            if (map[s2[right]] >= 0) {
                count++;
            }
            
            while (count === s1.length) {
                if (right - left + 1 === s1.length) {
                    return true;
                }
                
                if (map[s2[left]] !== undefined) {
                    map[s2[left]]++;
                    if (map[s2[left]] > 0) {
                        count--;
                    }
                }
                
                left++;
            }
        }
    }
    
    return false;
};