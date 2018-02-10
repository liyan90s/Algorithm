/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    //I 1  
    //V 5  
    //X 10  
    //L 50  
    //C 100  
    //D 500  
    //M 1,000  
    
    var ret = 0;
    
    for (var i = 0; i < s.length; i++) {
        switch (s[i]) {
            case 'I':
                if (i + 1 < s.length && s[i + 1] === 'V' || s[i + 1] === 'X') {
                    ret -= 1;
                } else {
                    ret += 1;
                }
                break;
            case 'V':
                ret += 5;
                break;
            case 'X':
                if (i + 1 < s.length && s[i + 1] === 'L' || s[i + 1] === 'C') {
                    ret -= 10;
                } else {
                    ret += 10;
                }
                break ;
            case 'L':
                ret += 50;
                break ;
            case 'C':
                if (i + 1 < s.length && s[i + 1] === 'D' || s[i + 1] === 'M') {
                    ret -= 100;
                } else {
                    ret += 100;
                }
                break ;
            case 'D':
                ret += 500;
                break ;
            case 'M':
                ret += 1000;
                break;
        }
    }
    
    return ret;
    
}