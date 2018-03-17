// Sweep Line
// make the building start point to be a negative of its height, this helps when sorting, the
// building starting point is always before the buildings end point.
class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return res;
        }
        
        List<int[]> points = new ArrayList<>();
        for (int[] building : buildings) {
            points.add(new int[] { building[0], -building[2] });
            points.add(new int[] { building[1], building[2] });
        }
        
        Collections.sort(points, (p1, p2) -> {
            if (p1[0] != p2[0]) {
                return p1[0] - p2[0];
            } else {
                return p1[1] - p2[1];
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        pq.offer(0);
        int prev = 0;
        
        for (int[] point : points) {
            if (point[1] < 0) {
                pq.offer(-point[1]);
            } else {
                pq.remove(point[1]);        // cost O(n); TODO: use TreeMap to make it into O(logn)
            }
            
            int curr = pq.peek();
            if (curr != prev) {
                res.add(new int[] {point[0], curr});
                prev = curr;
            }
        }
        
        return res;
    }
}