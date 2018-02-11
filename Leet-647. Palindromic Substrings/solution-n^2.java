class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPal(s, i, i, 0) + countPal(s, i, i + 1, 0);
        }
        
        return count;
    }
    
    public int countPal(String s, int left, int right, int count) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        
        return count;
    }
}