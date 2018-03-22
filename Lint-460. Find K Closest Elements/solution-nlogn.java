public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (A == null || A.length == 0 || k < 1 || A.length < k) {
            return new int[] {};
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1 - target) == Math.abs(o2 - target)) {
                return o1 - o2;
            } else {
                return Math.abs(o1 - target) - Math.abs(o2 - target);
            }
        });
        
        for (int val : A) {
            pq.offer(val);
        }
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        
        return res;
    }
}