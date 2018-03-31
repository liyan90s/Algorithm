class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || k < 1) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int right = 0;
        int res = 0;
        int count = 0;
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && count <= k) {
                char ch = s.charAt(right);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    count++;
                    map.put(ch, 1);
                }
                right++;
            }
            
            if (count > k) {
                res = Math.max(res, right - left - 1);
            } else {     // need to check when right ptr hits the end !!
                res = Math.max(res, s.length() - left);
            }
            
            char leftChar = s.charAt(left);
            if (map.containsKey(leftChar)) {
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    count--;
                    map.remove(leftChar);
                }
            }
        }
        
        return res;
    }
}