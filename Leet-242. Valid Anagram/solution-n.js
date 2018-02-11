/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s === null || t === null || s.length !== t.length) {
        return false;
    }
    
    var map = {};
    for (var i = 0; i < s.length; i++) {
        if (map[s[i]] !== undefined) {
            map[s[i]]++;
        } else {
            map[s[i]] = 1;
        }
    }
    
    for (var j = 0; j < t.length; j++) {
        if (map[t[j]] !== undefined && map[t[j]] > 0) {
            map[t[j]]--;
        } else {
            return false;
        }
    }
    
    return true;
};