public class Solution {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        if (a == 0) {
            return 0;
        } else if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 1 % b;
        }
        
        long res = 1;
        long base = (long) a;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res = (res % b * base % b) % b;
            }
            base = (base % b * base % b) % b;
        }
        
        return (int) res;
    }
}