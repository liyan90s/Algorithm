/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var checkInclusion = function(s1, s2) {
    if (s1 === null || s2 === null || s1.length > s2.length) {
        return false;
    }
    
    var map = {};
    for (var i = 0; i < s1.length; i++) {
        map[s1[i]] = map[s1[i]] !== undefined ? map[s1[i]] + 1 : 1;
    }
    
    var count = 0;
    var right = 0;
    
    for (var left = 0; left < s2.length; left++) {
        while (right < s2.length && count !== s1.length) {
            if (map[s2[right]] !== undefined) {
                map[s2[right]]--;
                
                if (map[s2[right]] >= 0) {
                    count++;
                }
            }
            right++;
        }
        
        if (count === s1.length) {
            if (right - left === s1.length) {
                return true;
            }
        }
        
        if (map[s2[left]] !== undefined) {
            map[s2[left]]++;
            
            if (map[s2[left]] > 0) {
                count--;
            }
        }
    }
    
    return false;
};