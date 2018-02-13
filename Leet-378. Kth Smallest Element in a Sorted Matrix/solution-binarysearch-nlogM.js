/**
 * @param {number[][]} matrix
 * @param {number} k
 * @return {number}
 */

// Time: O(nlogM), where M is the largest number in the matrix
var kthSmallest = function(matrix, k) {
    var m = matrix.length;
    var n = matrix[0].length;
    
    var left = matrix[0][0];
    var right = matrix[m - 1][n - 1];
    
    while (left <= right) {
        var mid = left + parseInt((right - left) / 2);
        var midExists = false;
        var count = 0;        
        
        var j = n - 1;
        for (var i = 0; i < m; i++) {
            // var j = n - 1;      // no need to reset j, since numbers to the bottom-right direction of matrix[i][j] is greater than matrix[i][j]
            while (j >= 0 && matrix[i][j] > mid) {
                j--;
            }

            if (matrix[i][j] === mid) {
                midExists = true;
            }            
            
            count += j + 1;
        }
        
        if (midExists && count === k ) {
            return mid;
        }
        
        if (count < k) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return left;
};