// Sweep Line
// make the building start point to be a negative of its height, this helps when sorting, the
// building starting point is always before the buildings end point.

class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return res;
        }
        
        List<Point> points = new ArrayList<>();
        for (int[] building : buildings) {
            points.add(new Point(building[0], -building[2]));
            points.add(new Point(building[1], building[2]));
        }
        
        Collections.sort(points, (o1, o2) -> {
            if (o1.x != o2.x) {
                return o1.x - o2.x;
            } else {
                return o1.height - o2.height;
            }
        });
        
        // build maxHeap to make the heightest to be at the first place
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // add 0 into maxHeap for convenience calculating the ground-line (地平线)
        pq.offer(0);
        int prev = 0;
        
        for (Point point : points) {
            if (point.height < 0) {
                pq.offer(-point.height);
            } else {
                pq.remove(point.height);   // cost O(n); TODO: use TreeMap to make it into O(logn)
            }
            
            int curr = pq.peek();
            if (curr != prev) {
                res.add(new int[] {point.x, curr});
                prev = curr;
            }
        }
        
        return res;
    }
    
    class Point {
        int x, height;
        public Point(int x, int height) {
            this.x = x;
            this.height = height;
        }
    }
}