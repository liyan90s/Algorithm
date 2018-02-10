class Solution {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        boolean isNeg = x < 0 ? true : false;
        x = Math.abs(x);
        int res = 0;
        
        while (x > 0) {
            int digit = x % 10;
            
            if (max / 10 < res || max / 10 == res && max % 10 < digit) {
                return 0;
            }
            
            res = 10 * res + digit;
            x /= 10;
        }
        
        return isNeg ? -res : res;
    }
}