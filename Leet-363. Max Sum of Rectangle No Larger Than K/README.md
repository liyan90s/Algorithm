## Description

Given a non-empty 2D matrix `matrix` and an integer `k`, find the max sum of a rectangle in the matrix such that its `sum` is **no larger** than `k`.

**Example:**
```java
Given matrix = [
  [1,  0, 1],
  [0, -2, 3]
]
k = 2
The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).
```

**Note:**
The rectangle inside the matrix must have an area > 0.
What if the number of rows is much larger than the number of columns?

*** 

## Approach
Sol1: Brute Force (must) -> O((mn)^2)
Scan every rectangle to see if it meets the requirement. If yes, than update the `res`.

Sol2: Binary Search / Balanced Binary Search Tree -> O(m^2nlogn)
[Reference](https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/discuss/83599/Accepted-C++-codes-with-explanation-and-references)

