class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        
        Arrays.sort(envelopes, (e1, e2) -> {
            if (e1[0] != e2[0]) {
                return Integer.compare(e1[0], e2[0]);
            } else {
                return Integer.compare(e1[1], e2[1]);
            }
        });
        
        int res = 1;
        int[] memo = new int[envelopes.length];
        memo[0] = 1;
        
        for (int i = 1; i < envelopes.length; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
            
            res = Math.max(res, memo[i]);
        }
        
        return res;
    }
}