/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var countNodes = function(root) {
    if (root == null) {
        return 0;
    }
    
    var leftHeight = getLeftHeight(root);
    var rightHeight = getRightHeight(root);
    
    if (leftHeight === rightHeight) {
        return Math.pow(2, leftHeight) - 1;
    }
    
    return countNodes(root.left) + countNodes(root.right) + 1;
};

var getLeftHeight = function(node) {
    var height = 0;
    while (node !== null) {
        node = node.left;
        height++;
    }
    
    return height;
};

var getRightHeight = function(node) {
    var height = 0;
    while (node !== null) {
        node = node.right;
        height++;
    }
    
    return height;
};
