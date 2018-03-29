/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[] {};
        }
        
        Map<Interval, Integer> map = new HashMap<>();
        map.put(null, -1);
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i], i);
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));
        
        int[] res = new int[intervals.length];
        res[map.get(intervals[intervals.length - 1])] = -1;
        for (int i = 0; i < intervals.length - 1; i++) {
            Interval rightInterval = search(intervals, i + 1, intervals[i].end);
            
            res[map.get(intervals[i])] = map.get(rightInterval);
        }
        
        return res;
    }
    
    public Interval search(Interval[] intervals, int from, int target) {
        int start = from;
        int end = intervals.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int currItvStart = intervals[mid].start;
            
            if (currItvStart < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (intervals[start].start >= target) {
            return intervals[start];
        }
        
        if (intervals[end].start >= target) {
            return intervals[end];
        }
        
        return null;
    }
}