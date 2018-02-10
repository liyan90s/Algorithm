class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int div = 1;
        int originalX = x;
        while (x >= 10) {
            div *= 10;
            x /= 10;
        }
        
        x = originalX;
        while (x > 0) {
            int first = x / div;
            int last = x % 10;
            
            if (first != last) {
                return false;
            }
            
            x -= first * div;
            x /= 10;
            
            div /= 100;
        }
        
        return true;
    }
}