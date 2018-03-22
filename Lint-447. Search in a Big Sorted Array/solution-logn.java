public class Solution {
    /*
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        if (reader == null) {
            return -1;
        }
        
        int left = 0;
        int right = 1;

        // find the upper bound
        while (reader.get(right) < target && reader.get(right) != 2147483647) {
            right <<= 1;
        }
        
        while (right > left && reader.get(right) == 2147483647) {
            right--;
        }
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int val = reader.get(mid);
            
            if (val == target || val > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (reader.get(left) == target) {
            return left;
        }
        
        if (reader.get(right) == target) {
            return right;
        }
        
        return -1;
    }
}