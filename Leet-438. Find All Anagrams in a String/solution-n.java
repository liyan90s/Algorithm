class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        if (s == null || p == null || s.length() < p.length()) {
            return res;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.containsKey(p.charAt(i)) ? map.get(p.charAt(i)) + 1 : 1);
        }
        
        int right = 0;
        int count = 0;
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && count < p.length()) {
                if (map.containsKey(s.charAt(right))) {
                    map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                    
                    if (map.get(s.charAt(right)) >= 0) {
                        count++;
                    }
                }
                
                right++;
            }
            
            if (count == p.length()) {
                if (right - left == p.length()) {
                    res.add(left);
                }
            }
            
            if (map.containsKey(s.charAt(left))) {
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                
                if (map.get(s.charAt(left)) > 0) {
                    count--;
                }
            }
        }
        
        return res;
    }
}