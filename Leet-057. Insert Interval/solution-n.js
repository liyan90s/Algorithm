/**
 * Definition for an interval.
 * function Interval(start, end) {
 *     this.start = start;
 *     this.end = end;
 * }
 */
/**
 * @param {Interval[]} intervals
 * @param {Interval} newInterval
 * @return {Interval[]}
 */

// Time: O(n)
var insert = function(intervals, newInterval) {
    if (intervals === null || intervals.length === 0) return [newInterval];

    var ret = [];
    var idx = 0, len = intervals.length;

    while (idx < len && intervals[idx].end < newInterval.start) {
        ret.push(intervals[idx]);
        idx++;
    }

    if (idx < len) {
        newInterval.start = Math.min(newInterval.start, intervals[idx].start);
    }
    ret.push(newInterval);

    while (idx < len && intervals[idx].start <= newInterval.end) {
        newInterval.end = Math.max(newInterval.end, intervals[idx].end);
        idx++;
    }

    while (idx < len) {
        ret.push(intervals[idx]);
        idx++;
    }

    return ret;
}
