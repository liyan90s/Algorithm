class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Queue<Integer[]> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            q.add(new Integer[] {i, i});
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                q.add(new Integer[] {i, i + 1});
            }
        }
        
        int res = 0;
        while (!q.isEmpty()) {
            Integer[] pos = q.poll();
            res++;
            
            int left = pos[0] - 1, right = pos[1] + 1;
            if (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                q.add(new Integer[] {left, right});
            }
        }
        
        return res;
    }
}