/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */

// Template version
var findAnagrams = function(s, p) {
    if (s === null || p === null || s.length < p.length) {
        return [];
    }
    
    var map = {};
    for (var i = 0; i < p.length; i++) {
        map[p[i]] = map[p[i]] === undefined ? 1 : map[p[i]] + 1;
    }
    
    var count = 0;
    var left = 0;
    var res = [];
    
    for (var right = 0; right < s.length; right++) {
        if (map[s[right]] !== undefined) {
            map[s[right]]--;
            
            if (map[s[right]] >= 0) {
                count++;
            }
            
            while (count === p.length) {
                if (right - left + 1 === p.length) {
                    res.push(left);
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
    }
    
    return res;
};