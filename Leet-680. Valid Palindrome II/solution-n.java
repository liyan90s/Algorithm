class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 2) {
            return true;
        }
        
        int left = 0, right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        
        if (left >= right) {
            return true;
        }
        
        return isPal(s, left + 1, right) || isPal(s, left, right - 1);
    }
    
    public boolean isPal(String s, int left, int right) {
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        
        return left >= right;
    }
}