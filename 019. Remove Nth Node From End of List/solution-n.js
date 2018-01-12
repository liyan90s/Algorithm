/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */

// Time: O(head.length)
var removeNthFromEnd = function(head, n) {
    if (head === null || head.next === null) return null;
    
    var dummyHead = new ListNode(0);
    dummyHead.next = head;
    var walker = dummyHead;
    var runner = dummyHead;
    
    while (n > 0) {
        if (runner === null) return null;
        
        runner = runner.next;
        n--;
    }
    
    while (runner.next != null) {
        walker = walker.next;
        runner = runner.next;
    }
    
    walker.next = walker.next.next;
    
    return dummyHead.next;
};