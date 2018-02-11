/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */

// Time: O(nklogk)
var mergeKLists = function(lists) {
    if (lists === null || lists.length === 0) {
        return lists;
    }
    
    return helper(lists, 0, lists.length - 1);
};

var helper = function(lists, left, right) {
    if (left === right) {
        return lists[left];
    }
    
    var middle = ~~((left + right) / 2);
    var leftLists = helper(lists, left, middle);
    var rightLists = helper(lists, middle + 1, right);
    
    return merge(leftLists, rightLists);
};

var merge = function(l1, l2) {
    if (l1 === null) {
        return l2;
    }
    
    if (l2 === null) {
        return l1;
    }
    
    var dummyHead = new ListNode(0);
    var runner = dummyHead;
    
    while (l1 !== null && l2 !== null) {
        if (l1.val < l2.val) {
            runner.next = l1;
            l1 = l1.next;
        } else {
            runner.next = l2;
            l2 = l2.next;
        }
        runner = runner.next;
    }
    
    runner.next = l1 !== null ? l1 : l2;
    
    return dummyHead.next;
};