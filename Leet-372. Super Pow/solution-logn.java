class Solution {
    private static final int M = 1337;
    
    public int superPow(int a, int[] b) {
        if (a == 0) {
            return 0;
        }
        
        int res = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            res = (res * fastPow(a, b[i])) % M;
            // when moving to the next bit in b[], we need to update a by fastPow(a, 10)
            // e.g.: (a^20) % M <==> {[(a^10) % M]^2} % M, where next bit b[i] = 2; and
            //       (a^10) % M <==> fastPow(a, 10)
            a = fastPow(a, 10); 
        }
        
        return res;
    }
    
    public int fastPow(int a, int n) {
        // use long to avoid overflow
        long res = 1;
        long base = (long) a;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res = (res % M * base % M) % M;
            }
            base = (base % M * base % M) % M;
        }
        
        return (int) res;
    }
}