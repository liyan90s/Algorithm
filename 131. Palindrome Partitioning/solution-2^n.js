/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function(s) {
    if (s === null || s.length === 0) {
        return [];
    }
    
    var results = [];
    var palMap = createPalMap(s);
    
    backtrack(s, results, [], 0, palMap);
    
    return results;
};

var backtrack = function(s, results, result, startIdx, palMap) {
    if (startIdx === s.length) {
        results.push(result.slice());
        return ;
    }
    
    for (var i = startIdx; i < s.length; i++) {
        if (palMap[startIdx][i]) {
            result.push(s.substring(startIdx, i + 1));
            backtrack(s, results, result, i + 1, palMap);
            result.pop();
        }
    }
};

var createPalMap = function(s) {
    var map = new Array(s.length);
    for (var i = 0; i < s.length; i++) {
        map[i] = new Array(s.length).fill(false);
    }
    
    for (var i = s.length - 1; i >= 0; i--) {
        for (var j = i; j < s.length; j++) {
            if (s[i] === s[j] && (j - i <= 2 || map[i + 1][j - 1])) {
                map[i][j] = true;
            }
        }
    }
    
    return map;
};