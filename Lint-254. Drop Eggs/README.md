## Description

There is a building of `n` floors. If an egg drops from the k th floor or above, it will break. If it's dropped from any floor below, it will not break.

You're given two eggs, Find `k` while minimize the number of drops for the worst case. Return the number of drops in the worst case.

**Clarification**
For n = 10, a naive way to find k is drop egg from 1st floor, 2nd floor ... kth floor. But in this worst case (k = 10), you have to drop 10 times.

Notice that you have two eggs, so you can drop at 4th, 7th & 9th floor, in the worst case (for example, k = 9) you have to drop 4 times.

**Example**
```java
Given n = 10, return 4.
Given n = 100, return 14.
```

*** 

## Approach
Drop the egg by some intervals. 
Each time we drop the first egg, we need to minimize the number of drops for the second egg in the worst case.
So we need to find a way that in the last case, which is the worst case, we just need to drop the second egg for 1 time, which means,
the interval for the first egg is decrease by `1` each time we drop it:
x + (x - 1) + (x - 2) + (x - 3) + ... + 1 = n