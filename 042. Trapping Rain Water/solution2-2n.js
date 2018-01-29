/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    if (height === null || height.length === 0) {
        return 0;
    }
    
    var maxHeight = [];
    var max = 0;
    for (var i = 0; i < height.length; i++) {
        maxHeight[i] = max;
        max = Math.max(max, height[i]);
    }
    
    max = 0;
    var area = 0;
    for (var i = height.length - 1; i >= 0; i--) {
        maxHeight[i] = Math.min(max, maxHeight[i]);
        max = Math.max(max, height[i]);
        area += maxHeight[i] > height[i] ? maxHeight[i] - height[i] : 0;
    }
    
    return area;
};