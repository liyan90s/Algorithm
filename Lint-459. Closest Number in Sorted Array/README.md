## Description

Given a target number and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to the given target.

Return `-1` if there is no element in the array.

**Notice**
There can be duplicate elements in the array, and we can return any of the indices with same value.

**Example**
```java
Given [1, 2, 3] and target = 2, return 1.

Given [1, 4, 6] and target = 3, return 1.

Given [1, 4, 6] and target = 5, return 1 or 2.

Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2.
```1

*** 

## Approach
First find the insertion index of the target `targetIndex`, then check:
* if targetIndex == 0, return 0; 边界
* if targetIndex == A.length, return A.length - 1; 边界
* now, since either we have `target` in the array, or the target's insertion place, which means `A[targetIndex] >= target`. So we just need to compare `A[targetIndex] - target` and `target - A[targetIndex - 1]`