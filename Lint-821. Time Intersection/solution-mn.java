/*
public class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
*/
public class Solution {
    /**
     * @param seqA: The seqA
     * @param seqB: The seqB
     * @return: The answer
     */
    public Point[] timeIntersection(Point[] seqA, Point[] seqB) {
        // Write your code here
        List<Point> list = new ArrayList<>();
        if (seqA == null || seqB == null || seqA.length == 0 || seqB.length == 0) {
            return new Point[] {};
        }
        
        for (int i = 0; i < seqA.length; i++) {
            Point userA = seqA[i];
            for (int j = 0; j < seqB.length; j++) {
                Point userB = seqB[j];
                
                if (userA.x > userB.y || userB.x > userA.y) {
                    continue ;
                } else {
                    int start = Math.max(userA.x, userB.x);
                    int end = Math.min(userA.y, userB.y);
                    list.add(new Point(start, end));
                }
            }
        }
        
        return list.toArray(new Point[list.size()]);
    }
}