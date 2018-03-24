public class Solution {
    /**
     * @param n: the number
     * @return: the rank of the number
     */
    public int kthPrime(int n) {
        if (n < 1) {
            return 0;
        }
        
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i <= n; i++) {
            boolean isPrime = true;
            for (Integer val : primes) {
                if (i % val == 0) {
                    isPrime = false;
                    break ;
                }
            }
            
            if (isPrime) {
                primes.add(i);
            }
        }
        
        return primes.size();
    }
}