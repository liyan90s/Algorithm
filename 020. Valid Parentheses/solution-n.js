/**
 * @param {string} s
 * @return {boolean}
 */

// Time: O(n)
var isValid = function(s) {
    if (s === null || s.length < 2) return false;
    
    var stack = [];
    for (var i = 0; i < s.length; i++) {
        if (s[i] === '(' || s[i] === '[' || s[i] === '{') {
            stack.push(s[i]);
        } else if (s[i] === ')' || s[i] === ']' || s[i] === '}') {
            if(checkValid(stack, s[i])) {
                stack.pop();    
            } else {
                return false;
            }
        }
    }
    
    return stack.length === 0;
};

var checkValid = function(stack, paren) {
    if (stack.length === 0) return false;
    
    var topStack = stack[stack.length - 1];
    switch (paren) {
        case ')':
            if (topStack !== '(') return false;
            break;
        case ']':
            if (topStack !== '[') return false;
            break;
        case '}':
            if (topStack !== '{') return false;
            break;
    }
    
    return true;
}