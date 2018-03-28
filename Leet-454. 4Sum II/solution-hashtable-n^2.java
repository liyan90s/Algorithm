// TIme: O(n^2), Space: O(n)
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null || D == null || A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int valA : A) {
            for (int valB : B) {
                int sum = valA + valB;
                map.put(sum, map.containsKey(sum) ? map.get(sum) + 1 : 1);
                // map.put(sum, map.getOrDefault(sum, 0) + 1);      // use Java 8 method
            }
        }
        
        int count = 0;
        for (int valC : C) {
            for (int valD : D) {
                int sum = -(valC + valD);
                count += map.containsKey(sum) ? map.get(sum) : 0;
                // count += map.getOrDefault(sum, 0);       // use Java 8 method
            }
        }
        
        return count;
    }
}