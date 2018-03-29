class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters == null || letters.length < 1) {
            return '0';
        }
        
        int start = 0, end = letters.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (letters[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (letters[start] > target) {
            return letters[start];
        } else if (letters[end] > target) {
            return letters[end];
        } else {
            return letters[0];
        }
    }
}