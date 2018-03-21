class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                res++;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        
        return set.isEmpty() ? res * 2 : res * 2 + 1;
    }
}