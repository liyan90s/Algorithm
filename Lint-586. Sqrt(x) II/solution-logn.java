public class Solution {
    /*
     * @param x: a double
     * @return: the square root of x
     */
    public double sqrt(double x) {
        // write your code here
        if (x <= 0) {
            return 0.0;
        }
        
        double left = 0.0, right = x;
        double eps = 1e-10;         // 0.0000000001
        if (x < 1.0) {
            right = 1.0;
        }
        
        while (right - left > eps) {
            double mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid;
            } else if (mid * mid < x) {
                left = mid;
            } else {
                return mid;
            }
        }
        
        return right;
    }
}