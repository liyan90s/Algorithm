public class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public List<List<Integer>> buildingOutline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return res;
        }
        
        List<int[]> points = new ArrayList<>();
        for (int[] building : buildings) {
            points.add(new int[] {building[0], -building[2]});
            points.add(new int[] {building[1], building[2]});
        }
        Collections.sort(points, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]);
        
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
        heightMap.put(0, 1);
        int prev = 0;
        List<int[]> segments = new ArrayList<>();
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
                segments.add(new int[] {point[0], curr});
                prev = curr;
            }
        }
        // above, segments is result of LeetCode - 218. The Skyline Problem
        
        // below is for this problem's result
        int start = segments.get(0)[0];
        int segmentHeight = segments.get(0)[1];
        for (int i = 1; i < segments.size(); i++) {
            int[] segment = segments.get(i);
            List<Integer> outline = new ArrayList<>();
            if (segmentHeight != 0) {
                outline.add(start);
                outline.add(segment[0]);
                outline.add(segmentHeight);
                res.add(new ArrayList<>(outline));
                outline = new ArrayList<>();
            }
            
            start = segment[0];
            segmentHeight = segment[1];
        }
        
        return res;
    }
}