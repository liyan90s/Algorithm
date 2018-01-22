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
        if (map[s1[i]] !== undefined) {
            map[s1[i]]++;
        } else {
            map[s1[i]] = 1;
        }
    }
    
    var count = 0;
    var left = 0;
    for (var right = 0; right < s2.length; right++) {
        if (map[s2[right]] !== undefined) {
            if (map[s2[right]] > 0) {
                map[s2[right]]--;
                count++;
            } else {
                while (map[s2[right]] === 0) {
                    if (map[s2[left]] !== undefined) {
                        map[s2[left]]++;
                        count--;
                    }
                    left++;
                }
                map[s2[right]]--;
                count++;
            }
        } else {
            count = 0;
            while (left <= right) {
                if (map[s2[left]] !== undefined) {
                    map[s2[left]]++;
                }
                left++;
            }
        }
        
        if (count === s1.length) {
            return true;
        }
    }
    
    return count === s1.length;
};