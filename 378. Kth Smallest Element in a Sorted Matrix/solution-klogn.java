class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(matrix[0].length, (p1, p2) -> matrix[p1[0]][p1[1]] - matrix[p2[0]][p2[1]]);
        
        for (int j = 0; j < matrix[0].length; j++) {
            pq.offer(new int[] {0, j});
        }
        
        for (int i = 1; i < k; i++) {
            int[] idx = pq.poll();
            if (idx[0] == matrix.length - 1) {
                continue ;
            }
            pq.offer(new int[] {idx[0] + 1, idx[1]});
        }
        
        int[] ans = pq.poll();
        return matrix[ans[0]][ans[1]];
    }
}