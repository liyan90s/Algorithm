## Description

Given a big sorted array with positive integers sorted by `ascending` order. The array is so big so that you can not get the length of the whole array directly, and you can only access the `kth` number by `ArrayReader.get(k)` (or ArrayReader->get(k) for C++). 

Find the `first` index of a target number. Your algorithm should be in `O(log k)`, where k is the first index of the target number.

Return `-1`, if the number doesn't exist in the array.

**Notice**
If you accessed an inaccessible index (outside of the array), ArrayReader.get will return 2,147,483,647.

**Example**
```java
Given [1, 3, 6, 9, 21, ...], and target = 3, return 1.

Given [1, 3, 6, 9, 21, ...], and target = 4, return -1.
```

*** 

## Approach
The trick is to find the upper bound `right` of the binary search space.
We know that the `right` must be `>=` the target.
So we every time we miltiply the `right` by 2 until `right >= target`.