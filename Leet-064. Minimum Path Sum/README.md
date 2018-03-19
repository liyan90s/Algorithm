### Desctiption

Given a `m x n` grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

**Note**: You can only move either down or right at any point in time.

**Example**
```java
[[1,3,1],
 [1,5,1],
 [4,2,1]]
Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
```

***

### Approach

Use dp, `dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]`;

To optimize space:
Since we observe that `dp[i][j]` only needs the value of `dp[i - 1][j]` and `dp[i][j - 1]`, we can use a 1-D array to store the previous rows value.
Then, when calculating the current `dp[j]`, we can use current `dp[j - 1]`, which we've already updated in this row, and previous `dp[j]` to update the current `dp[j]`.