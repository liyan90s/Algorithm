class Solution {
    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0 || d == null || d.isEmpty()) {
            return "";
        }
        
        String res = "";
        for (String str : d) {
            if (isSubsequence(str, s)) {
                if (str.length() > res.length() || str.length() == res.length() && str.compareTo(res) < 0) {
                    res = str;
                }
            }
        }
        
        return res;
    }
    
    public boolean isSubsequence(String sub, String s) {
        int i = 0, j = 0;
        while (i < sub.length() && j < s.length()) {
            if (sub.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        
        return i == sub.length();
    }
}