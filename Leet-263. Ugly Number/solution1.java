class Solution {
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        
        int[] primes = {2, 3, 5};

        for (int val : primes) {
            while (num % val == 0) {
                num /= val;
            }
        }
        
        return num == 1;
    }
}