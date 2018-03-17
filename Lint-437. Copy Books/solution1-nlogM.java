// Time: O(n log m) where n is the number of books and m is the sum of the pages.
public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        if (pages == null || pages.length == 0 || k < 1) {
            return 0;
        }
        
        int max = 0;
        int total = 0;
        for (int p : pages) {
            max = Math.max(max, p);
            total += p;
        }
        
        int left = max;
        int right = total;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (countPeople(pages, mid) > k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    public int countPeople(int[] pages, int limit) {
        int count = 1;
        int sum = pages[0];
        
        for (int i = 1; i < pages.length; i++) {
            if (sum + pages[i] > limit) {
                count++;
                sum = 0;
            }
            sum += pages[i];
        }
        
        return count;
    }
}