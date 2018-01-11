/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */

// Time: O(n^2), Space: O(n^2)
var isMatch = function(s, p) {
    if (s === null || p === null) return false;
    if (p.length === 0) return s.length === 0;
    
    var lenS = s.length, lenP = p.length;
    var dp = new Array(lenS + 1);
    for (var i = 0; i <= lenS; i++) {
        dp[i] = new Array(lenP + 1).fill(false);
    }
    
    dp[0][0] = true;
    for (var i = 1; i <= lenS; i++) {
        dp[i][0] = false;
    }
    
    for (var j = 1; j <= lenP; j++) {
        dp[0][j] = j > 1 && p[j - 1] === '*' && dp[0][j - 2];
    }
    
    for (var i = 1; i <= lenS; i++) {
        for (var j = 1; j <= lenP; j++) {
            if (p[j - 1] !== '*') {
                dp[i][j] = (s[i - 1] === p[j - 1] || p[j - 1] === '.') && dp[i - 1][j - 1];
            } else {
                var matchEmpty = dp[i][j - 2];
                var matchNonEmpty = (s[i - 1] === p[j - 2] || p[j - 2] === '.') && dp[i - 1][j];
                dp[i][j] = matchEmpty || matchNonEmpty;
            }
        }
    }
    
    return dp[lenS][lenP];
};