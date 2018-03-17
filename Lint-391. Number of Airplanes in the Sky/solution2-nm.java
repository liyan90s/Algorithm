/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

// Time: O(nm), where n = airplanes.size(), m = （所有飞机里飞行时间最长的时间跨度）
public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        
        int n = 0;
        for (Interval itv : airplanes) {
            n = Math.max(n, itv.start);
            n = Math.max(n, itv.end);
        }
        
        int[] count = new int[n];
        int res = 0;
        for (Interval itv : airplanes) {
            for (int i = itv.start; i < itv.end; i++) {
                count[i - 1]++;
                res = Math.max(res, count[i - 1]);
            }
        }
        
        return res;
    }
}