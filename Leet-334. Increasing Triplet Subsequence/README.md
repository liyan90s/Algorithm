## Description
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return `true` if there exists i, j, k, such that 
`arr[i] < arr[j] < arr[k]` given `0 ≤ i < j < k ≤ n-1`,
else return `false`.
Your algorithm should run in `O(n)` time complexity and O(1) space complexity.

**Examples**
```java
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.
```

*** 

## Approach
* Create two pivot: `small` and `big`;
* Loop through the `nums` array;
* `if val <= small`, let `small = val`;
* else if `val <= big`, let `big = val`;
* else, return `true`.

The logic is that when you update the `big`, it means there is already a smaller `val` in the past.
Similarly, when you find a `val` that is greater than `big`, it means there are already two `val`s that are smaller than the current `val` --> return `true`.