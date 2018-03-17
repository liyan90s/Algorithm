public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        if (airplanes == null || airplanes.isEmpty()) {
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (Interval i : airplanes) {
            for (int j = i.start; j < i.end; j++) {
                map.put(j, map.containsKey(j) ? map.get(j) + 1 : 1);
                res = Math.max(res, map.get(j));
            }
        }
        
        return res;
    }
}