/**
 * @param {string} s
 * @return {number}
 */

// Time: O(n^2), Space: O(1)
var countSubstrings = function(s) {
    if (s === null || s.length === 0) return 0;
    
    var queue = [];
    for (var i = 0; i < s.length; i++) {
        queue.push([i, i]);
        if (i + 1 < s.length && s[i] === s[i + 1]) {
            queue.push([i, i + 1]);
        }
    }
    
    var ret = 0;
    while (queue.length > 0) {
        ret++;
        var startIdxes = queue.shift();
        var l = startIdxes[0], r = startIdxes[1];
        if (l - 1 >= 0 && r + 1 < s.length && s[l - 1] === s[r + 1]) {
            queue.push([l - 1, r + 1]);
        }
    }
    
    return ret;
};
