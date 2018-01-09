/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    var l = 0, r = 0, max = 0;
    var hash = {};
    
    while (r < s.length) {
        if (!hash[s[r]]) {
            hash[s[r]] = true;
        } else {
            max = Math.max(max, r - l);
            while (s[l] != s[r]) {
                hash[s[l]] = false;
                l++;
            }
            l++;
        }
        r++;
    }
    
    return Math.max(max, r - l);
};