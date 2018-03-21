class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        s.trim();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            if (left < right) {
                char leftCh = Character.toLowerCase(s.charAt((left)));
                char rightCh = Character.toLowerCase(s.charAt(right));
                if (leftCh != rightCh) {
                    return false;
                }
                
                left++;
                right--;
            }
        }
        
        return true;
    }
}