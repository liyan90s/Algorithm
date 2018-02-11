/**
 * @param {string} s
 * @return {number}
 */
// Time: O(n^2), Space: O(n^2)
var longestPalindromeSubseq = function(s) {
    if (s === null || s.length < 1) return 0;
    
    var dp = new Array(s.length);
    for (var i = 0; i < s.length; i++) {
        dp[i] = new Array(s.length).fill(0);
    }
    
    for (var i = s.length - 1; i >= 0; i--) {
        dp[i][i] = 1;
        for (var j = i + 1; j < s.length; j++) {
            if (s[i] === s[j]) {
                dp[i][j] = dp[i + 1][j - 1] + 2;
            } else {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
    }
    
    return dp[0][s.length - 1];
};
