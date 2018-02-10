class Solution {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        
        boolean isNeg = false;
        int idx = 0;
        int res = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            idx++;
            isNeg = str.charAt(0) == '-' ? true : false;
        }
        
        for (int i = idx; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                break ;
            }
            
            if (max / 10 < res || max / 10 == res && max % 10 < digit) {    // check overflow
                return isNeg ? min : max;
            }
            
            res = res * 10 + digit;
        }
        
        return isNeg ? -res : res;
    }
}