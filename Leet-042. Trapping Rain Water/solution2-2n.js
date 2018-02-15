/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    if (height === null || height.length < 2) {
        return 0;
    }
    
    var res = 0;
    var max = 0;         // record the max height of the LEFT bar for every container
    var maxHeight = [];
    for (var i = 0; i < height.length; i++) {
        maxHeight[i] = max;
        max = Math.max(max, height[i]);
    }
    
    max = 0;            // the max height of the RIGHT bar for every container
    for (var i = height.length - 1; i >= 0; i--) {
        var containerHeight = Math.min(max, maxHeight[i]);      // Math.min(rightBar, leftBar) determines the height of the container 
        res += Math.max(0, containerHeight - height[i]);
        max = Math.max(max, height[i]);
    }
    
    return res;
};