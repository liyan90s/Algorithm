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
        
        long half = fastPower(a, b, n / 2);
        long res = (half * half) % b;
        
        if (n % 2 != 0) {
            res = (res * a % b) % b;
        }
        
        return (int) res;
    }
}