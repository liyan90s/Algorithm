/**
 * Definition for an interval.
 * function Interval(start, end) {
 *     this.start = start;
 *     this.end = end;
 * }
 */
/**
 * @param {Interval[]} intervals
 * @return {Interval[]}
 */

// Time: O(nlogn)
var merge = function(intervals) {
    if (intervals === null || intervals.length === 0) return [];

    intervals.sort(function(a, b) {
        if (a.start != b.start) {
            return a.start - b.start;
        } else {
            return a.end - b.end;
        }
    });

    var ret = [];
    var curr = intervals[0];

    for (var i = 1; i < intervals.length; i++) {
        var next = intervals[i];
        if (curr.end < next.start) {
            ret.push(curr);
            curr = next;
        } else {
            curr.end = Math.max(curr.end, next.end);
        }
    }

    ret.push(curr);
    
    return ret;
};
