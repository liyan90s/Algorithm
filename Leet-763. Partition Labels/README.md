## Description

A string S of lowercase letters is given. We want to partition this string into **as many parts as possible** so that each letter appears in **at most** one part, and return a list of integers representing the size of these parts.

**Example 1:**
```java
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
```

**Note:**
S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.

*** 

## Approach
Greedy:
Since every character must be all in one part, we need to find the last index for every character. 
1. scan the string, and find the last idnex of each character in this string.
2. make two pointers: `currStart` -> the current partition starting index, `currLast` -> the last index that the current partition will hit to meet the requirement;
3. scan the string, every time we do 2 checks:
** if the current character's last index `lastIndex > currLast`, if yes, update `currLast = lastIndex`, which means the current partition need to go further
** if current index `i == currLast`, which means we hit the end of the current partition, then we can update the `res`
