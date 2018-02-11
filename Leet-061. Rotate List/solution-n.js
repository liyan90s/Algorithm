/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */

// Time: O(n)
var rotateRight = function(head, k) {
    if (head === null || k === 0) return head;
    
    var dummyHead = new ListNode(0);
    var walker = dummyHead;
    var runner = dummyHead;
    walker.next = head;
    var len = 0;
    
    while (runner.next != null) {
        len++;
        runner = runner.next;
    }
    
    k = k % len;
    runner = new ListNode(0);
    runner.next = head;
    
    while (k > 0) {
        runner = runner.next;
        k--;
    }
    
    while (runner.next != null) {
        runner = runner.next;
        walker = walker.next;
    }
    
    runner.next = head;
    dummyHead.next = walker.next;
    walker.next = null;
    
    return dummyHead.next;
};