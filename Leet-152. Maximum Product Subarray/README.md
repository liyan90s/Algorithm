## Description

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array `[2,3,-2,4]`,
the contiguous subarray `[2,3]` has the largest `product = 6`.

*** 

## Approach
Since we are looking for the maximum product subarray, we need to store both the maximum product AND minimum product (especially when the minimum product is negative) from a certain index UP TO the current index.

Then, if the current value is negative, we swap the `currMax` and `currMin`, because after the multiply with current negative value, the previous `currMax` will be less than the previous `currMin`.

Next, we need to update the `currMax = Math.max(nums[i], nums[i] * currMax)` and `currMin = Math.min(nums[i], nums[i] * currMin)`.
Then, update the `res` if `currMax > res`.