## Description

You have `k` lists of sorted integers in ascending order. Find the **smallest** range that includes at least one number from each of the `k` lists.

We define the range `[a,b]` is smaller than range `[c,d]`: if `b-a < d-c` or `a < c if b-a == d-c`.

**Example 1:**
```java
Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
```

**Note:**
* The given list may contain duplicates, so ascending order means `>=` here.
* 1 <= k <= 3500
* -10^5 <= value of elements <= 10^5.

*** 

## Approach
Image you are merging k sorted array using a `heap (priority queue)`. Then everytime you pop the smallest element out and add the next element of that array to the heap. By keep doing this, you will have the smallest range.

1. since all the lists are sorted, we put the first elements from all the lists into the `pq`.
2. keep doing below until the `pq.size() != nums.size()`:
* poll the smallest element out, and check if `max - node.val < range`;
* if yes, then update the `start`, `end`, and `range`
* then if the `node.index + 1 < nums.get(node.row).size()`, put the next node after this smallest element into the `pq`