class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (k > n) {
            return res;
        }
        
        dfs(n, k, res, new ArrayList<>(), 1);
        return res;
    }
    
    public void dfs(int n, int k, List<List<Integer>> res, List<Integer> combination, int startNum) {
        if (combination.size() == k) {
            res.add(new ArrayList<>(combination));
            return ;
        }
        
        for (int i = startNum; i <= n; i++) {
            combination.add(i);
            dfs(n, k, res, combination, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}