## Description

Calculate the `a^n % b`, where a, b and n are all 32bit integers.

**Example**
```java
For 2^31 % 3 = 2

For 100^1000 % 1000 = 0
```

** 

## Approach
Need to know the formula: `(i * j) % k = (i % k * j % k) % k`
Then we can use the binary search in recursive way:
* check if `n < 0`, `n == 0`
* calculate the fastPower(a, b, n / 2)
* then check if n % 2 != 0, if yes, then we need to multiply one more a % b