// HashMap
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }            
        }
        
        for (int j = 0; j < t.length(); j++) {
            if (map.containsKey(t.charAt(j))) {
                map.put(t.charAt(j), map.get(t.charAt(j)) - 1);
            } else {
                return false;
            }
        }
        
        for (Character key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        
        return true;
    }
}


// HashMap with Iterator
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }            
        }
        
        for (int j = 0; j < t.length(); j++) {
            if (map.containsKey(t.charAt(j))) {
                map.put(t.charAt(j), map.get(t.charAt(j)) - 1);
            } else {
                return false;
            }
        }
        
        Set<Character> set = map.keySet();
        Iterator<Character> iter = set.iterator();
        while (iter.hasNext()) {
            char key = iter.next();
            if (map.get(key) != 0) {
                return false;
            }
        }
        
        return true;
    }
}