class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        res.add(list);
        
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> newRes = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                for (List<Integer> li : res) {
                    List<Integer> newList = new ArrayList<>(li);
                    newList.add(j, nums[i]);
                    newRes.add(newList);
                }
            }
            
            res = newRes;
        }
        
        return res;
    }
}