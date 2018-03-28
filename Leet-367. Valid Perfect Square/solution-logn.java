class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 1) {
            return false;
        }
        
        int start = 1, end = num;
        while (start + 1 < end) {
            // use long type to avoid overflow when doing: mid * mid
            long mid = start + (end - start) / 2;
            
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                end = (int) mid;
            } else {
                start = (int) mid;
            }
        }
        
        return start * start == num || end * end == num;
    }
}