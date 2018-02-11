class Solution {
    public int divide(int dividend, int divisor) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        // Overflow
        if (divisor == 0) {
            return dividend > 0 ? max : min;
        }
        
        if (dividend == min && divisor == -1) {
            return max;
        }
        
        // check negative
        boolean isNeg = false;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            isNeg = true;
        }
        
        // make it to be long type, to avoid left shifting to be a negative integer
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        
        int i = 0;
        while (dvs << (i + 1) <= dvd) {
            i++;
        }
        
        int res = 0;
        while (dvd >= dvs) {
            if (dvd >= dvs << i) {
                dvd -= dvs << i;
                res += 1 << i;
            }
            i--;
        }
        
        return isNeg ? -res : res;
    }
}