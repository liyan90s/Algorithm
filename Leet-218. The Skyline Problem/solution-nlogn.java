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
        
        // use TreeMap instead of a PriorityQueue to make remove entry to be O(logn) time
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
        heightMap.put(0, 1);
        int prev = 0;
        
        for (Point point : points) {
            if (point.height < 0) {
                // found a building starting point, add it into heightMap
                Integer cnt = heightMap.get(-point.height);
                cnt = cnt == null ? 1 : cnt + 1;
                heightMap.put(-point.height, cnt);
            } else {
                // found a building ending here
                Integer cnt = heightMap.get(point.height);
                if (cnt == 1) {
                    // there's only 1 building with this height, so when this building ends here, delete it from heightMap
                    heightMap.remove(point.height);
                } else {
                    heightMap.put(point.height, cnt - 1);
                }
            }
            
            int curr = heightMap.firstKey();
            if (prev != curr) {
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