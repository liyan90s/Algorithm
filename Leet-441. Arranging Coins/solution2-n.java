// botto-up
class Solution {
    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }
        
        int i = 1;
        while (n >= 0) {
            n -= i;
            if (n < 0) {
                return i - 1;
            }
            i++;
        }
        
        return 0;
    }
}

// top-down
class Solution {
    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }
        
        int i = 2;
        long used = 1; // to avoid overflow
        while (used + i <= n) {
            used += i;
            i++;
        }
        
        return i - 1;
    }
}
