// Time: O(nlogn)
class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return res;
        }
        
        List<int[]> points = new ArrayList<>();
        for (int[] building : buildings) {
            points.add(new int[] {building[0], -building[2]});
            points.add(new int[] {building[1], building[2]});
        }
        Collections.sort(points, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]);
        
        // use TreeMap instead of a PriorityQueue to make remove entry to be O(logn) time
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder()); 
        heightMap.put(0, 1);
        int prev = 0;
        for (int[] point : points) {
            if (point[1] < 0) {
                Integer cnt = heightMap.get(-point[1]);
                cnt = cnt == null ? 1 : cnt + 1;
                heightMap.put(-point[1], cnt);
            } else {
                Integer cnt = heightMap.get(point[1]);
                if (cnt == 1) {
                    heightMap.remove(point[1]);
                } else {
                    heightMap.put(point[1], cnt - 1);
                }
            }
            
            int curr = heightMap.firstKey();
            if (prev != curr) {
                res.add(new int[] {point[0], curr});
                prev = curr;
            }
        }
        
        return res;
    }
}