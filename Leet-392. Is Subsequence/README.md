## Description

Given a string `s` and a string `t`, check if `s` is *subsequence* of `t`.

You may assume that there is only lower case English letters in both s and t. 
`t` is potentially a very **long** (length ~= 500,000) string, and `s` is a **short** string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

**Example 1:**
```java
s = "abc", t = "ahbgdc"

Return true.
```

**Example 2:**
```java
s = "axc", t = "ahbgdc"

Return false.
``

**Follow up:**
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

*** 

## Approach
1. Sol: two pointers

2. Follow up:
When there are lots of S, each time scan the `T` is inefficient.
So we think of if we can use a hashtable like structure to save the lookup time for `T`, that will be better.
Since the index of the each character in `T` is sorted, we can make use of it.

* Preprocess `T`: Create a HashMap<Character, List<Integer>>, which makes each character in `T` as key, and stores its corresponding index in the list, which is an ascending list.
* For each of incoming `S`, scan it from the start character, we need to search a `index` for the current character of `S`, such that this `index` is greater than the previous one `prev`
** If we have this `index`, than we keep scanning `S` using the same trick;
** Otherwise, return `false`, since we cannot find a position in `T` for this current character of `S`
