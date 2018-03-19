## Description

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

* Integers in each row are sorted from left to right.
* The first integer of each row is greater than the last integer of the previous row.

**Example**
```java
Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
```

*** 

## Approach
#### Sol1: 
* binary search on rows to find locate the `rowIndex` which the `target` is potentially be
* binary search on cols in the `rowIndex` to find `target`

#### Sol2:
* treat the 2D matrix to be a sorted list, index range is: `[0, m * n - 1]`, where `m = matrix.length`,  `n = matrix[0].length`
* for a specific index: `row = mid / n`, `col = mid % n`.
* **NOTE** this may cause overflow when doing `m * n`

#### Sol3:
* start from the top-right corner, check if current val < target, `row++`;
* if current val > target, `col--`.
* **NOTE**: the reason why we can do this is to treat the matrix as a binary search tree, which root is at the top-right or bottom-left corner !!