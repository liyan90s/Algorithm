public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length < 2) {
            return ;
        }
        
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }
    
    public void rainbowSort(int[] colors, int left, int right, int colorFrom, int colorTo) {
        if (left >= right) {
            return ;
        }
        
        if (colorFrom >= colorTo) {
            return ;
        }
        
        int pivot = colorFrom + (colorTo - colorFrom) / 2;
        int start = left, end = right;
        while (start <= end) {
            while (start <= end && colors[start] <= pivot) {
                start++;
            }
            
            while (start <= end && colors[end] > pivot) {
                end--;
            }
            
            if (start <= end) {
                swap(colors, start, end);
                start++;
                end--;
            }
        }
        
        rainbowSort(colors, left, end, colorFrom, pivot);
        rainbowSort(colors, start, right, pivot + 1, colorTo);
    }
    
    public void swap(int[] colors, int l, int r) {
        int temp = colors[l];
        colors[l] = colors[r];
        colors[r] = temp;
    }
}