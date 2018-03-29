class Solution {
    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }
        
        long start = 1, end = n;
        long nLong = (long) n;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            
            if (mid + mid * mid == 2 * nLong) {
                return (int) mid;
            } else if (mid + mid * mid < 2 * nLong) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end + end * end <= 2 * nLong) {
            return (int) end;
        } else {
            return (int) start;
        }
    }
}