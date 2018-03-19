## Description

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

**Example**
```java
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.
```

*** 

## Approach
#### Sol1: Time: O(n), Space: O(1)
* use `i` to store the length of the result;
* every time, I check `if (i < 2 || val > nums[i - 2])`, because we only allow at most 2 duplicates in the array;
* the method can be applied to in general allow at most `k` duplicates, just check `if (i < k || val > nums[i - k])`

#### Sol2: Time: O(n), Space: O(n)
* use a hashmap to track the number of times one value exists in the array