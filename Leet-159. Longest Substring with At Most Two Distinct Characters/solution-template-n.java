class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int right = 0;
        int count = 0;
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && count <= 2) {
                char rightChar = s.charAt(right);
                if (map.containsKey(rightChar)) {
                    map.put(rightChar, map.get(rightChar) + 1);
                } else {
                    count++;
                    map.put(rightChar, 1);
                }
                right++;
            }
            
            if (count > 2) {
                res = Math.max(res, right - left - 1);
            } else {      // need to check when right ptr hits the end !!
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