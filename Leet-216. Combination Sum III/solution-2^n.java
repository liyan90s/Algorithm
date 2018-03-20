class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 3) {
            return res;
        }
        
        dfs(k, n, 0, 1, res, new ArrayList<>());
        return res;
    }
    
    public void dfs(int k, int n, int sum, int start, List<List<Integer>> res, List<Integer> comb) {
        if (k == 0) {
            if (sum == n) {
                res.add(new ArrayList<>(comb));
            }
            
            return ;
        }
        
        if (sum > n) {
            return ;
        }
        
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            dfs(k - 1, n, sum + i, i + 1, res, comb);
            comb.remove(comb.size() - 1);
        }
    }
}