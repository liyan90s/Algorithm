class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        
        Arrays.sort(candidates);
        dfs(candidates, target, res, new ArrayList<>(), 0, 0, new boolean[candidates.length]);
        
        return res;
    }
    
    public void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> combination, int sum, int startIdx, boolean[] used) {
        if (sum > target) {
            return ;
        }
        
        if (sum == target) {
            res.add(new ArrayList<>(combination));
            return ;
        }
        
        for (int i = startIdx; i < candidates.length; i++) {
            if (used[i] || i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue ;
            }
            
            used[i] = true;
            combination.add(candidates[i]);
            dfs(candidates, target, res, combination, sum + candidates[i], i + 1, used);
            combination.remove(combination.size() - 1);
            used[i] = false;
        }
    }
}