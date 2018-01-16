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
    if (lists === null || lists.length === 0) return null;
    
    return mergeHelper(lists, 0, lists.length - 1);
};

var mergeHelper = function(lists, l, r) {
    if (l === r) {
        return lists[l];
    }
    
    var m = ~~((l + r) / 2);
    var leftLists = mergeHelper(lists, l, m);
    var rightLists = mergeHelper(lists, m + 1, r);
    
    return mergeTwoLists(leftLists, rightLists);
};

var mergeTwoLists = function(l1, l2) {
    if (l1 === null) return l2;
    if (l2 === null) return l1;
    
    var dummyHead = new ListNode(0);
    var runner = dummyHead;
    
    while (l1 != null && l2 != null) {
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