## Description

Your are given an array of positive integers `nums`.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than `k`.

**Example 1:**
```java
Input: nums = [10, 5, 2, 6], k = 100
Output: 8

Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].

Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
```

**Note:
* 0 < nums.length <= 50000.
* 0 < nums[i] < 1000.
* 0 <= k < 10^6.

*** 
## Approach
1. keep multiply `nums[right] * product` until we have `product` >= k;
2. stop and do `res += right - left`, then divide `product /= nums[left]`;

e.g.: `nums = [1, 2, 3, 4], k = 7`:
* when `left = 0` and keep moving `right` until `right` moves to index = 3 (`right == 3`), now `product = 24 > k = 7`;
* stop and calculate the previous subarrays starting at `left` pointer that meets the requirement, which are: `[1], [1, 2], [1, 2, 3]`, so there are 3 (`right - left = 3 - 0 = 3`) subarrays. (**NOTE**: we **only** calculate the number of subarrays starting from the `left` pointer, because other subarrays starting from later index will be calculte later when we move the `left` pointer !!)
* then divide `nums[left]`.
* keep doing the above steps until `product < k` again. Then we re-increase the `right` pointer.
