class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return res;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[] {i, 0});
        }
        
        int count = 0;
        while (!pq.isEmpty()) {
            count++;
            int[] pair = pq.poll();
            res.add(new int[] {nums1[pair[0]], nums2[pair[1]]});
            
            if (count == k) {
                return res;
            }
            
            if (pair[1] + 1 < nums2.length) {
                pq.offer(new int[] {pair[0], pair[1] + 1});
            }            
        }
        
        return res;
    }
}