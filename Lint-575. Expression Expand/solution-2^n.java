public class Solution {
    /*
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int num = 0;
        int parenCount = 0;
        String substr = "";
        StringBuffer sb = new StringBuffer();
        
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                if (parenCount > 0) {
                    substr += c;
                }
                parenCount++;
            } else if (c == ']') {
                parenCount--;
                if (parenCount == 0) {
                    String expandedStr = expressionExpand(substr);
                    for (int i = 0; i < num; i++) {
                        sb.append(expandedStr);
                    }
                    
                    num = 0;
                    substr = "";
                } else {
                    substr += c;
                }
            } else if (Character.isDigit(c)) {
                if (parenCount == 0) {
                    num = num * 10 + c - '0';
                } else {
                    substr += c;
                }
            } else {
                if (parenCount == 0) {
                    sb.append(c);
                } else {
                    substr += c;
                }
            }
        }
        
        return sb.toString();
    }
}