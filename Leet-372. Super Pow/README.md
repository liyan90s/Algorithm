## Description

Your task is to calculate ab mod `1337` where `a` is a `positive` integer and b is an `extremely large positive` integer given in the form of an array.

**Example1:**
```java
a = 2
b = [3]

Result: 8
```

**Example2:**
```java
a = 2
b = [1,0]

Result: 1024
```

*** 

## Approach
Need to know the formula: `(a * b) % k = (a % k * b % k) % k`, and 
`(a ^ 20 % k) <==> [(a ^ 10 % k) ^ 2] % k`