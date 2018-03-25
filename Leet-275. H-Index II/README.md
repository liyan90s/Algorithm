## Description

Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

According to the definition of `h-index` on Wikipedia: "A scientist has index `h` if `h` of his/her N papers have at least `h` citations each, and the other `N − h` papers have **no** more than h citations each."

*** 

## Approach
Since the array is sorted, we just need to check the `mid`: (len = citations.length)
Basically, we need to find the first index that satisfy: `citaions[mid] >= len - mid`
* citaitons[mid] == len - mid, -> return len - mid
* citations[mid] > len - mid, -> already an `h-index`, because we have `len - mid` number of papers and since sorted, each of them has citations that is greater than citaions[mid], so it matches the definition of an `h-index`. But we need to decrease `mid`, which is essentially go to left, to see if we can find a larger h-index;
* citations[mid] < len - mid, not an h-index, since we cannot guarantee that every paper has more than citations[mid] citations. So go to right.