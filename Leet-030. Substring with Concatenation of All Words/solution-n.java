class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return res;
        }
        
        int wordLen = words[0].length();
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.containsKey(str) ? map.get(str) + 1 : 1);
        }
        
        for (int i = 0; i <= s.length() - words.length * wordLen; i++) {
            int count = 0;
            HashMap<String, Integer> copy = new HashMap<>(map);
            int left = i;
            String substr = s.substring(left, left + wordLen);
            while (copy.containsKey(substr) && copy.get(substr) > 0) {
                count++;
                copy.put(substr, copy.get(substr) - 1);
                
                left += wordLen;
                if (left > s.length() - wordLen) {
                    break ;
                }
                
                substr = s.substring(left, left + wordLen);
            }
            
            if (count == words.length) {
                res.add(i);
            }
        }
        
        return res;
    }
}