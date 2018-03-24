public class Solution {
    /**
     * @param num: An integer
     * @return: an integer array
     */
    public List<Integer> primeFactorization(int num) {
        List<Integer> res = new ArrayList<>();
        if (num < 2) {
            return res;
        }
        
        int originalNum = num;
        for (int i = 2; i * i <= originalNum; i++) {
            while (num % i == 0) {
                res.add(i);
                num /= i;
            }
        }
        
        if (num != 1) {
            res.add(num);
        }
        
        return res;
    }
}