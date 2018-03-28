// Time: O(kmlogn), where k = number of incoming S (S1, S2, S3, .., Sk); m = maximum length of the incoming S; n = t.length()
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new ArrayList<Integer>());
            }
            map.get(ch).add(i);
        }
        
        int prev = -1;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (!map.containsKey(ch)) {
                return false;
            } else {
                prev = binarySearch(map.get(ch), prev);
                if (prev == -1) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public int binarySearch(List<Integer> list, int prevIndex) {
        int left = 0, right = list.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (list.get(mid) <= prevIndex) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (list.get(left) > prevIndex) {
            return list.get(left);
        } 
        
        if (list.get(right) > prevIndex) {
            return list.get(right);
        }
        
        return -1;
    }
}