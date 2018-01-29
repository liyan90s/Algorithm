/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    if (height === null || height.length <= 2) {
        return 0;
    }
    
    var maxLeftHeight = [];
    var area = 0;
    var max = 0;
    for (var i = 0; i < height.length; i++) {
        maxLeftHeight[i] = max;
        max = Math.max(max, height[i]);
    }
    
    max = 0;
    var maxRightHeight = [];
    for (var i = height.length - 1; i >= 0; i--) {
        maxRightHeight[i] = max;
        max = Math.max(max, height[i]);
    }
    
    for (var i = 0; i < height.length; i++) {
        var minHeight = Math.min(maxLeftHeight[i], maxRightHeight[i]);
        area += minHeight > height[i] ? minHeight - height[i] : 0;
    }
    
    return area;
};