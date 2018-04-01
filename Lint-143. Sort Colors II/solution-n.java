public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length <= 1 || k < 1) {
            return ;
        }
        
        int[] counts = new int[k + 1];
        for (int val : colors) {
            counts[val]++;
        }
        
        int index = 0;
        for (int i = 1; i <= k; i++) {
            while (counts[i] > 0) {
                colors[index] = i;
                index++;
                counts[i]--;
            }
        }
    }
}