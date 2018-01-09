/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    if (l1 === null) return l2;
    if (l2 === null) return l1;
    
    var carry = 0;
    var dummyHead = new ListNode(0);
    var curr = dummyHead;
    
    while (l1 != null || l2 != null) {
        var x = (l1 != null) ? l1.val : 0;
        var y = (l2 != null) ? l2.val : 0;
        var temp = carry + x + y;
        
        curr.next = new ListNode(temp % 10);
        carry = parseInt(temp / 10);
        
        curr = curr.next;
        if (l1 != null) l1 = l1.next;
        if (l2 != null) l2 = l2.next;
    }
    
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    
    return dummyHead.next;
};