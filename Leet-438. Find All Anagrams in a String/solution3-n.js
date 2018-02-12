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
        if (map[p[i]] === undefined) {
            map[p[i]] = 1;
        } else {
            map[p[i]]++;
        }
    }
    
    var left = 0;
    var res = [];
    var count = 0;
    for (var right = 0; right < s.length; right++) {
        if (map[s[right]] !== undefined) {
            while (map[s[right]] === 0) {
                if (map[s[left]] !== undefined) {
                    map[s[left]]++;
                    count--;
                }
                left++;
            }
            
            map[s[right]]--;
            count++;
        } else {
            count = 0;
            while (left <= right) {
                if (map[s[left]] !== undefined) {
                    map[s[left]]++;
                }
                left++;
            }
        }
        
        if (count === p.length) {
            res.push(left);
        }
    }
    
    return res;
};