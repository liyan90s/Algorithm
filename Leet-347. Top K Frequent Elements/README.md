## Description

Given a non-empty array of integers, return the k most frequent elements.

**Example**
```java
Given [1,1,1,2,2,3] and k = 2, return [1,2].
```

**Note**
* You may assume `k` is always valid, 1 ≤ k ≤ number of unique elements.
* Your algorithm's time complexity must be **better** than O(n log n), where n is the array's size.

*** 

## Approach
#### Sol1: Bucket sort
1. use a hashtable to store the each value's frequency
2. use a `bucket` (an array of List), whose index is the frequence and value is the list of elements with that frequency
3. scan the `bucket` from the end to the beginning, to fill the `res`

**Note:** 
the way to create array of List:
`List<Integer>[] buckets = new List[len];`

#### Sol2: Heap
1. use a hashtable to store the each value's frequency
2. use maxHeap to store the `Map.Entry` by comparing entry's value:
* `PriorityQueue<Map.Entry> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());`