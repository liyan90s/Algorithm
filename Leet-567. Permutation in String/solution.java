class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.containsKey(s1.charAt(i)) ? map.get(s1.charAt(i)) + 1 : 1);
        }
        
        int count = 0;
        int right = 0;
        for (int left = 0; left < s2.length(); left++) {
            while (right < s2.length() && count < s1.length()) {
                if (map.containsKey(s2.charAt(right))) {
                    map.put(s2.charAt(right), map.get(s2.charAt(right)) - 1);
                    
                    if (map.get(s2.charAt(right)) >= 0) {
                        count++;
                    }
                }
                
                right++;
            }
            
            if (count == s1.length()) {
                if (right - left == s1.length()) {
                    return true;
                }
            }
            
            if (map.containsKey(s2.charAt(left))) {
                map.put(s2.charAt(left), map.get(s2.charAt(left)) + 1);
                if (map.get(s2.charAt(left)) > 0) {
                    count--;
                }
            }
        }
        
        return false;
    }
}