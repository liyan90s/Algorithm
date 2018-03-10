Numbers keep coming, return the median of numbers at every time a new number added.

**Clarification**
**Median** is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is `A[(n - 1) / 2]`. 
**Example**
```java
if A=[1,2,3], median is 2. If A=[1,19], median is 1.
```

**Example**
```java
For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].

For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].

For numbers coming list: [2, 20, 100], return [2, 2, 20].
```

**Challenge **
Total run time in `O(nlogn)`.