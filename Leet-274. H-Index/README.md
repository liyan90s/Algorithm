## Description

Given an array of citations (each citation is a *non-negative* integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index `h` if `h` of his/her N papers have at least `h` citations each, and the other `N − h` papers have **no** more than h citations each."

**Example**
```java
Given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
```

**Note** 
If there are several possible values for h, the `maximum` one is taken as the h-index.

*** 
## Approach
Counting sort:
We first create an array `bucket` with length n + 1, where n = citations.length, since index is 0-based.
The reason we make the length of `bucket` to be n + 1 is because the h-index can be at most `n` (since we have at most `n` books). We want `n` to be an index in the `bucket`, so make the length of `bucket` to be n + 1.
Then we scan for the `citations`, regard each value of the citations corresponding to the index of the bucket:
* if citations[i] >= n, then we make bucket[n]++;
* else, bucket[citations[i]]++;

Then, we scan from the back of the bucket to the beginning, and `count` the number of paper we have found.
Whenever the total `count` exceeds the current `index` of bucket, meaning that we have the current index number of papers that have reference greater than or equal to the current index. So we found the result!