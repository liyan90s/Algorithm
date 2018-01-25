public class Solution {
    /*
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        int right = 0;
        int count = 0;
        int maxLen = 0;
        
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && count <= k) {
                if (map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) > 0) {
                    map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
                } else {
                    map.put(s.charAt(right), 1);
                    count++;
                }
                right++;
            }
            
            if (count > k) {
                maxLen = Math.max(maxLen, right - left - 1);
            } else {                                                // need to check the case when right ptr hits the end
                maxLen = Math.max(maxLen, s.length() - left);
            }
            
            if (map.containsKey(s.charAt(left)) && map.get(s.charAt(left)) > 0) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    count--;
                }
            }
        }
        
        return maxLen;
    }
}