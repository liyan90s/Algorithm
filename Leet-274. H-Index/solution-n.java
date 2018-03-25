class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int n = citations.length;
        int[] bucket = new int[n + 1];
        for (int val : citations) {
            if (val >= n) {
                bucket[n]++;
            } else {
                bucket[val]++;
            }
        }
        
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += bucket[i];
            if (count >= i) {
                return i;
            }
        }
        
        return 0;
    }
}