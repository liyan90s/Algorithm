class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0 || arr.length < k) {
            return res;
        }
        
        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
        } else if (x > arr[arr.length - 1]) {
            for (int i = arr.length - k; i < arr.length; i++) {
                res.add(arr[i]);
            }
        } else {
            int insertIdx = binarySearch(arr, x);
            int left = Math.max(0, insertIdx - k);
            int right = Math.min(arr.length - 1, insertIdx + k);
            
            while (right - left + 1 > k) {
                if (x - arr[left] <= arr[right] - x) {
                    right--;
                } else {
                    left++;
                }
            }
            
            for (int i = left; i < left + k; i++) {
                res.add(arr[i]);
            }
        }
        
        return res;
    }
    
    public int binarySearch(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}