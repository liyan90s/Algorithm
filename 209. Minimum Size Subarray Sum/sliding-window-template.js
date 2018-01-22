/**
 * Sliding Window Template:
 * Use 2 pointers both from the beginning to loop through to the end,
 * 1) while condition is true, move the right pointer and update context
 * 2) check if one result is found, update the res
 * 3) update context and move left pointer later
 */
var minSubArrayLen = function(s, nums) {
    var sum = 0;
    var right = 0;
    var res = nums.length + 1;
    
    for (var left = 0; left < nums.length; left++) {
        while (right < nums.length && sum < s) {    // while loop (sum / counter)
            sum += nums[right];                     // update context (sum / hashmap)
            right++;                                // move right pointer
        }
        
        if (sum >= s) {                             // check if one result
            res = Math.min(res, right - left);      // update res
        }
        
        sum -= nums[left];                          // update context and move left pointer later
    }
    
    return res > nums.length ? 0 : res;
};