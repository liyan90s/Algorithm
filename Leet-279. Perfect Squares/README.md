## Description

Given a positive integer `n`, find the **least** number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to `n`.

**Example**
```java
Given n = 12, return 3 because 12 = 4 + 4 + 4; 
given n = 13, return 2 because 13 = 4 + 9.
```

*** 

## Approach
#### Sol1: DP
Idea is if we know `n = i + j * j`, and the least number of perfect square that sums to `i` (i <= n) is `dp[i]`, then `dp[n] = dp[i] + 1` .

**状态方程**
```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
    }
}
```

#### Sol2: BFS
Idea is the same. But here we use queue.

#### Sol3: Bi-directional BFS
Optimized from **Sol2** .
