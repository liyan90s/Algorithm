class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        
        Arrays.sort(candidates);
        dfs(candidates, target, res, new ArrayList<>(), 0, 0);
        
        return res;
    }
    
    public void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> combination, int sum, int startIdx) {
        if (sum > target) {
            return ;
        }
        
        if (sum == target) {
            res.add(new ArrayList<>(combination));
            return ;
        }
        
        for (int i = startIdx; i < candidates.length; i++) {
            combination.add(candidates[i]);
            dfs(candidates, target, res, combination, sum + candidates[i], i);
            combination.remove(combination.size() - 1);
        }
    }
}