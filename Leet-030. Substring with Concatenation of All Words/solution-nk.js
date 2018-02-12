/**
 * @param {string} s
 * @param {string[]} words
 * @return {number[]}
 */

// Time: O(nk), n: s.length, k: words.length
// Space: O(mk), m: words[0].length
var findSubstring = function(s, words) {
    if (s === null || words === null) {
        return [];
    }
    
    var map = resetMap(words);
    
    var res = [];
    for (var j = 0; j <= s.length - words.length * words[0].length; j++) {
        var left = j;
        var substr = s.substring(left, left + words[0].length);
        var count = 0;
        while (map[substr] !== undefined && map[substr] > 0) {
            count++;
            map[substr]--;
            left += words[0].length;
            substr = s.substring(left, left + words[0].length);
        }
        
        if (count === words.length) {
            res.push(j);
        }
        
        if (count > 0) {
            map = resetMap(words);
        }
    }
    
    return res;
};

var resetMap = function(words) {
    var map = {};
    for (var i = 0; i < words.length; i++) {
        if (map[words[i]] === undefined) {
            map[words[i]] = 1;
        } else {
            map[words[i]]++;
        }
    }
    
    return map;
};