## Description
Given an array of integers and an integer `k`, you need to find the total number of continuous subarrays whose sum equals to `k`.

**Example 1:**
```java
Input:nums = [1,1,1], k = 2
Output: 2
```

**Note:**
1. The length of the array is in range [1, 20,000].
2. The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

*** 

## Approach
**Sol1**: Hashtable
1. We create a `sum` variable to store all the sum UP TO a given index, adnd use a hashtable `preSum` to store all the previous sums.
2. When the current sum minus k is included in the `preSum` (`preSum.containsKey(sum - k)`), that means from the index where that previous sum Up To (e.g.: previous sum is upto index `i`), there must be a subarray with a sum equals `k` from `i + 1` to `j`.
3. Now, we update the `res += preSum.get(sum - k)`, cause **after** the ending index of each of the previous sum equals to `sum - k` (we say those ending index are: `i1`, `i2`, `i3`, ...) to the current index `j`, can form subarrays that has sum = k.


**Sol2**: Brute Force to check all the Subarray
