/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/

public class Solution {
    /*
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        if (n <= 0) {
            return 0;
        }
        
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (!SVNRepo.isBadVersion(mid)) {
                left = mid + 1;
            } else {
                if (mid - 1 == 0) {
                    return 1;
                } else if (SVNRepo.isBadVersion(mid - 1)) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        
        return 0;
    }
}