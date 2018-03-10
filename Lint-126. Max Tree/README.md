Given an integer array with no duplicates. A max tree building on this array is defined as follow:

The root is the maximum number in the array
The left subtree and right subtree are the max trees of the subarray divided by the root number.
Construct the max tree by the given array.

Given `[2, 5, 6, 0, 3, 1]`, the max tree constructed by this array is:
```java

    6
   / \
  5   3
 /   / \
2   0   1
```