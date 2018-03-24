public class Solution {
    /**
     * @param n: An integer
     * @return: The sum of a and b
     */
    public int dropEggs(int n) {
        if (n < 0) {
            return 0;
        }
        
        int i = 0;
        long res = 0;
        while (res < n) {
            res += i;
            i++;
        }
        
        return i - 1;
    }
}