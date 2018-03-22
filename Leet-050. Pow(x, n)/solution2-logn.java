class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        
        return n < 0 ? 1 / pow(x, -n) : pow(x, n);
    }
    
    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        
        double half = pow(x, n / 2);
        return n % 2 == 0 ? half * half : x * half * half;
    }
}