## Description
Given an unsorted array of integers, find the length of longest increasing subsequence.

**Example**
```java
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
Note that there may be more than one LIS combination, it is only necessary for you to return the length.
```

Your algorithm should run in `O(n^2)` complexity.

**Follow up**: Could you improve it to `O(n log n)` time complexity?

*** 

## Approach

**1. DP with Binary Search (Tricky !!)**
* Create an `int[] dp`, which is an ascending sequence, store the correct position of the current val (`nums[i]`);
* Loop through the `nums`, and find the correct position `index` of current val (`nums[i]`) needed to be inserted into the `dp`;
* If the insert index `index == len`, we increase `len` by `1`, e.g.:
```java
input: [0, 8, 4, 12, 2]

dp: [0]
dp: [0, 8]
dp: [0, 4]
dp: [0, 4, 12]
dp: [0, 2, 12] 
```
**NOTE**: `dp` is not the longest increasing subsequence, but length of `dp` array results in length of Longest Increasing Subsequence.

**2. DP**
* Create an `int[] dp` to store the longest increasing subsequence at the current index;
* We loop through all the previous vals (`dp[j]`) **UPTO** index `i`, and keep updating `dp[i]` if `dp[i] < 1 + dp[j]`;
* Then after each iteration, we compare the current `dp[i]` and the `res` by doing `res = Math.max(res, dp[i]);`.

