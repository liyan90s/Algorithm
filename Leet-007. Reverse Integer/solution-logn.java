class Solution {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
        }
        
        x = Math.abs(x);
        int res = 0;
        
        while (x > 0) {
            int digit = x % 10;
            
            if (max / 10 < res || max - digit < res * 10) {
                return 0;
            }
            
            res = 10 * res + digit;
            x /= 10;
        }
        
        return isNeg ? -res : res;
    }
}