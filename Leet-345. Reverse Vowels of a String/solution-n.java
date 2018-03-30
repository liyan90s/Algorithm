class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        int start = 0, end = s.length() - 1;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');        
        
        char[] arr = s.toCharArray();
        while (start < end) {
            while (start < end && !set.contains(arr[start])) {
                start++;
            }
            
            while (start < end && !set.contains(arr[end])) {
                end--;
            }
            
            if (start < end) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        
        return new String(arr);
    }
}