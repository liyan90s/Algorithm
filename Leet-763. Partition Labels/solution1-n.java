class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        
        int currStart = 0, currLast = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int lastIndex = last[ch - 'a'];
            
            if (lastIndex > currLast) {
                currLast = lastIndex;
            }
            
            if (i == currLast) {
                res.add(i - currStart + 1);
                currStart = i + 1;
            }
        }
        
        return res;
    }
}