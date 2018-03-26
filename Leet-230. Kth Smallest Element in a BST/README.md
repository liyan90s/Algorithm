
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

**Note**
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

**Follow up**
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

*** 

## Approach
Binary search:
* first find the number of nodes in the left subtree;
* if `k == countLeft + 1`, means the `root` is the kth smallest element, return root.val;
* else if `k <= countLeft`, means the kth smallest element is in the left subtree, search the left part;
* else, now k should be `k > countLeft + 1`, then search the right part by `kthSmallest(root.right, k - countLeft - 1)`, k needs to subtract all the nodes in the left subtree and the root, so it's `k - countLeft - 1`.

**Follow Up**
If we have many insert/delete actions, it's better to make:
1. one more pointer to point to the kth smallest TreeNode;
2. make a pointer for each tree node to point to their parent

* so when the added/deleted node is larger than the kth element, we don't need to do anything;
* if added/deleted node is `<=` the kth element:
** if added node is <= kth elmenet, we need to find the tree node that is just smaller than the current kth smallest tree node;
** if deleted node is <= kth element, we need to find the next node that is just greater than the current kth smallest tree node. (with a `parent` pointer, it's easier to find the successor tree node)
