/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function(s, p) {
    if (s === null || p === null || s.length < p.length) {
        return [];
    }
    
    var map = {};
    for (var i = 0; i < p.length; i++) {
        map[p[i]] = map[p[i]] !== undefined ? map[p[i]] + 1 : 1;
    }
    
    var count = 0;
    var right = 0;
    var res = [];
    
    for (var left = 0; left < s.length; left++) {
        while (right < s.length && count !== p.length) {
            if (map[s[right]] !== undefined) {
                map[s[right]]--;
                
                if (map[s[right]] >= 0) {
                    count++;
                }
            }
            right++;
        }
        
        if (count === p.length) {
            if (right - left === p.length) {
                res.push(left);
            }
        }
        
        if (map[s[left]] !== undefined) {
            map[s[left]]++;
            if (map[s[left]] > 0) {
                count--;
            }
        }        
    }
    
    return res;
};