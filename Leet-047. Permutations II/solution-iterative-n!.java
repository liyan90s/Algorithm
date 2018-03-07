// when seeing a duplicate, we only add it in front of the duplciate element
// So `break` when same number exists in the permutation.
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        List<Integer> firstList = new ArrayList<>();
        firstList.add(nums[0]);
        res.add(firstList);
        
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> newRes = new ArrayList<>();
            for (List<Integer> list : res) {
                for (int j = 0; j <= i; j++) {
                    if (j > 0 && list.get(j - 1) == nums[i]) {
                        break ;
                    }
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(j, nums[i]);
                    newRes.add(newList);
                }
            }
            
            res = newRes;
        }
        
        return res;
    }
}