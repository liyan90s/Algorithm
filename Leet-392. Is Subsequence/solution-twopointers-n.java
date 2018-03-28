class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }
        
        if (s.length() == 0) {
            return true;
        }
        
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            while (j < t.length() && t.charAt(j) != s.charAt(i)) {
                j++;
            }
            
            if (j == t.length()) {
                break ;
            }
            
            i++;
            j++;
        }
        
        return i == s.length();
    }
}