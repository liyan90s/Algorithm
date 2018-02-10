/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */

var isMatch = function(s, p) {
    if (p.length === 0) return s.length === 0;
    
    if (p.length > 1 && p[1] === '*') {
        return isMatch(s, p.substring(2)) || s.length > 0 && isCharMatch(s[0], p[0]) && isMatch(s.substring(1), p);
    } else {
        return s.length > 0 && isCharMatch(s[0], p[0]) && isMatch(s.substring(1), p.substring(1));
    }
};

var isCharMatch = function(ch1, ch2) {
    return ch1 === ch2 || ch2 === '.';
};
