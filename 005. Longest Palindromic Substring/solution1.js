/**
 * @param {string} s
 * @return {string}
 */

// Time: O(n^2), Space: O(1)
var longestPalindrome = function(s) {
    if (s === null || s.length <= 1) return s;

    var ret = "";
    for (var i = 0; i < s.length; i++) {
        var rc1 = findLongest(s, i, i);
        ret = rc1.length > ret.length ? rc1 : ret;

        var rc2 = findLongest(s, i, i + 1);
        ret = rc2.length > ret.length ? rc2 : ret;
    }

    return ret;
}

var findLongest = function(s, l, r) {
    while (l >=0 && r < s.length && s[l] === s[r]) {
        l--;
        r++;
    }

    return s.substring(l + 1, r);
}

