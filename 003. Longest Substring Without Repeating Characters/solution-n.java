class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Set<Character> set = new HashSet<>();
        int right = 0;
        int maxLen = 0;
        
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            
            maxLen = Math.max(maxLen, right - left);
            
            set.remove(s.charAt(left));
        }
        
        return maxLen;
    }
}