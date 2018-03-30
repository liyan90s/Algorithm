class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        int start = 0, end = s.length() - 1;
        char[] sArr = s.toCharArray();
        while (start < end) {
            char temp = sArr[start];
            sArr[start] = sArr[end];
            sArr[end] = temp;
            
            start++;
            end--;
        }
        
        return new String(sArr);
    }
}