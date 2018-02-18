class Solution {
    public int mySqrt(int x) {
        if (x <= 0) {
            return x;
        }
        
        long left = 0, right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (mid * mid > x) {
                right = mid - 1;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                return (int) mid;
            }
        }
        
        return (int) right;     // we choose the lower bound if the result has decimal
    }
}