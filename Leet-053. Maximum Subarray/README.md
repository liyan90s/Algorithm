## Description

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array `[-2,1,-3,4,-1,2,1,-5,4]`,
the contiguous subarray `[4,-1,2,1]` has the largest `sum = 6`.

*** 

## Approach
We use `sum` to store the sum from a certain index UP To current index. 
If `sum < 0`, it means use `sum` will not get a better result, so just set `sum = nums[i]`; Otherwise, set `sum += nums[i]`.
Then, compare current `res` with `sum`.