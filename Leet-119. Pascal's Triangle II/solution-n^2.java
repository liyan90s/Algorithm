class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevList = new ArrayList<>();
        if (rowIndex < 0) {
            return prevList;
        }
        
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> currList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currList.add(1);
                } else {
                    currList.add(prevList.get(j) + prevList.get(j - 1));
                }
            }
            
            prevList = currList;
        }
        
        return prevList;
    }
}