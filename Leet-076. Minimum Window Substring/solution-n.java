class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        String res = "";
        int right = 0;
        int minLen = s.length() + 1;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.containsKey(t.charAt(i)) ? map.get(t.charAt(i)) + 1 : 1);
        }
        
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && count < t.length()) {
                if (map.containsKey(s.charAt(right))) {
                    map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                    
                    if (map.get(s.charAt(right)) >= 0) {
                        count++;
                    }
                }
                
                right++;
            }
            
            if (count == t.length()) {
                if (right - left < minLen) {
                    res = s.substring(left, right);
                    minLen = right - left;
                }
            }
            
            if (map.containsKey(s.charAt(left))) {
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                if (map.get(s.charAt(left)) > 0) {
                    count--;
                }
            }
        }
        
        return minLen > s.length() ? "" : res;
    }
}