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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i));
            i++;
        }
        
        if (i == intervals.size()) {
            res.add(newInterval);
            return res;
        }
        
        newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
        while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        
        res.add(newInterval);
        while (i < intervals.size()) {
            res.add(intervals.get(i));
            i++;
        }
        
        return res;
    }
}