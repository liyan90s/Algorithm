/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    if (height === null || height.length === 0) {
        return 0;
    }
    
    var left = 0;
    var right = height.length - 1;
    var area = 0;
    
    while (left < right) {
        var minHeight = Math.min(height[left], height[right]);
        
        if (minHeight === height[left]) {
            left++;
            while (left < right && height[left] < minHeight) {
                area += minHeight - height[left];
                left++;
            }
        } else {
            right--;
            while (left < right && height[right] < minHeight) {
                area += minHeight - height[right];
                right--;
            }
        }
    }
    
    return area;
};