/**
 * @param {string} s
 * @return {string}
 */

// Time: O(n^2), Space: O(n^2)
var longestPalindrome = function(s) {
    if (s === null || s.length <= 1) return s;

    var pal = new Array(s.length);
    for (var i = 0; i < pal.length; i++) {
        pal[i] = new Array(s.length);
    }

    var ret = "";
    for (var i = s.length - 1; i >= 0; i--) {
        for (var j = i; j < s.length; j++) {
            if (s[i] === s[j] && (j - i <= 2 || pal[i + 1][j - 1])) {
                pal[i][j] = true;
                if (j - i + 1 > ret.length) {
                    ret = s.substring(i, j + 1);
                }
            }
        }
    }

    return ret;
}
