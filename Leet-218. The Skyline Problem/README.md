[Problem Link](https://leetcode.com/problems/the-skyline-problem/description/)

Sweepline is used in solving the problem. `List<int[]> height` is used to save each of the line segments including both start and end point. The trick here is to set the start segment as negative height. This has a few good uses:

  * make sure the start segment comes before the end one after sorting.

  * when pushing into the queue, it is very each to distinguish either to add or remove a segment.

  * when the two adjacent building share same start and end x value, the next start segment always come before due to the negative height, this makes sure that when we peek the queue, we always get the value we are supposed to get. When the first building is lower, when we peek the queue, we get the height of the second building, and the first building will be removed in the next round of iteration. When the second building is lower, the first peek returns the first building and since it equals to prev, the height will not be added.