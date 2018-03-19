### Description

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

**Example**
```java
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
```

**Note**: m and n will be at most 100.

***

### Approach
When see a `1`, set the `dp[i][j] = 0`, else, `dp[i][j] = dp[i - 1][j] + dp[i][j - 1]`;

To optimize space:
Since we observe that `dp[i][j]` only needs the value of `dp[i - 1][j]` and `dp[i][j - 1]`, we can use a 1-D array to store the previous rows value.
Then, when calculating the current `dp[j]`, we can use current `dp[j - 1]`, which we've already updated in this row, and previous `dp[j]` to update the current `dp[j]`.