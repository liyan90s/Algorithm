### Description

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

**Follow up:**
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

***

### Approach
**Sol1: Time: O(m * n), Space: O(1)**
** use `first row` -> `fr` and `first col` -> `fc` to indicate if current `row` / `col` needed to be filled with `0` later.
** 1st scan the whole matrix, if `matrix[i][j] == 0`, set `matrix[0][j] = 0` and `matrix[i][0] = 0`, we also check if this `0` is in the first row and in the first col.
*** 2nd scan if at certain point `(i, j)`, if `matrix[0][j] == 0` or `matrix[i][0] == 0`, we set current position to be 0: `matrix[i][j] = 0`
*** finally, check if we need to set `0` for the first row or first col

**Sol2: Time: O(m * n), Space: O(m + n)**
use 2 sets, one store the rows need to be filled with `0` later, the other stores the cols need to be filled with `0` later