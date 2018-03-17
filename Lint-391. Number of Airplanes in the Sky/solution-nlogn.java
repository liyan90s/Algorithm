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


/*
 * when an airplanes starts to fly, count++,
 * when landing, cont--.
 * since landing should come first before taking-off, 
 * we sort the landing airplane time before the taking-off airplane time
 */
public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        if (airplanes == null || airplanes.isEmpty()) {
            return 0;
        }
        
        List<Point> points = new ArrayList<>();
        for (Interval i : airplanes) {
            points.add(new Point(i.start, 1));  // flag = 1 means taking off
            points.add(new Point(i.end, 0));    // flag = 0 means landing
        }
        
        Collections.sort(points, (o1, o2) -> {
            if (o1.time == o2.time) {
                return o1.flag - o2.flag;
            } else {
                return o1.time - o2.time;
            }
        });
        
        int count = 0;
        int res = 0;
        for (Point point : points) {
            if (point.flag == 1) {
                count++;
            } else {
                count--;
            }
            
            res = Math.max(res, count);
        }
        
        return res;
    }
    
    class Point {
        int time;
        int flag;
        
        public Point(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
}