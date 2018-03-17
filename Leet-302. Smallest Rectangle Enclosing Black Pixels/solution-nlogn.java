public class Solution {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        
        int left = findLeft(image, 0, y);
        int right = findRight(image, y, image[0].length - 1);
        int top = findTop(image, 0, x, left, right);
        int bottom = findBottom(image, x, image.length - 1, left, right);
        
        return (right - left + 1) * (bottom - top + 1);
    }
    
    public boolean helper(char[][] image, int mid, int start, int end, boolean isHorizontal) {
        for (int i = start; i <= end; i++) {
            if (isHorizontal) {
                if (image[i][mid] == '1') {
                    return true;
                }
            } else {
                if (image[mid][i] == '1') {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public int findLeft(char[][] image, int lo, int hi) {
        int left = lo, right = hi;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            boolean hasBlack = helper(image, mid, 0, image.length - 1, true);
            
            if (hasBlack) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (helper(image, left, 0, image.length - 1, true)) {
            return left;
        } else {
            return right;
        }
    }
    
    public int findRight(char[][] image, int lo, int hi) {
        int left = lo, right = hi;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            boolean hasBlack = helper(image, mid, 0, image.length - 1, true);
            
            if (hasBlack) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (helper(image, right, 0, image.length - 1, true)) {
            return right;
        } else {
            return left;
        }
    }
    
    public int findTop(char[][] image, int lo, int hi, int start, int end) {
        int left = lo, right = hi;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            boolean hasBlack = helper(image, mid, start, end, false);
            
            if (hasBlack) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (helper(image, left, start, end, false)) {
            return left;
        } else {
            return right;
        }
    }
    
    public int findBottom(char[][] image, int lo, int hi, int start, int end) {
        int left = lo, right = hi;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            boolean hasBlack = helper(image, mid, start, end, false);            
            
            if (hasBlack) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (helper(image, right, start, end, false)) {
            return right;
        } else {
            return left;
        }
    }
}