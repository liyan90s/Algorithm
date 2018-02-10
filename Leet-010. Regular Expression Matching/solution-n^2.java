class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            match[i][0] = false;
        }
        
        for (int j = 1; j <= p.length(); j++) {
            match[0][j] = j > 1 && p.charAt(j - 1) == '*' && match[0][j - 2];
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    boolean matchEmpty = match[i][j - 2];
                    boolean matchSomething = isCharMatch(s.charAt(i - 1), p.charAt(j - 2)) && match[i - 1][j];
                    match[i][j] = matchEmpty || matchSomething;
                } else {
                    match[i][j] = isCharMatch(s.charAt(i - 1), p.charAt(j - 1)) && match[i - 1][j - 1];
                }
            }
        }
        
        return match[s.length()][p.length()];
    }
    
    public boolean isCharMatch(char chS, char chP) {
        return chS == chP|| chP == '.';
    }
}