## Description
Given two arrays, write a function to compute their intersection.

**Example**
```java
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
```

**Note:**
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.


**Follow up:**
1. What if the given array is already sorted? How would you optimize your algorithm?
2. What if nums1's size is small compared to nums2's size? Which algorithm is better?
3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?


*** 

## Approach
Follow up 1:
If already sorted, then use two pointers to reduce space complexity without using a HashTable;

Follow up 2:
Two pointer is better. Reduce extra space, and while loop will end before investigating all the elements in `nums2`.

Follow up 3:
If cannot load all elements into memory, will use external sort to sort the two arrays first. 
External sort can be external merge sort to sort the elements in chunks:
* chunks of data small enough to fit into the main memory is sorted, and stored in temporary files;
* then in the merge phase, the subfiles are merged into a single large file;
* this is like the Map-reduce in the data engineering field.

Then, after sorting, we use two pointers method. To load the chunks of two arrays that fit into the main memory and check the comparison.