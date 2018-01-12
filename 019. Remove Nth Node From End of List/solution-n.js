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

// Time: O(m)
var removeNthFromEnd = function(head, n) {
    if (head === null || head.next === null) return null;
    
    var dummyHead = new ListNode(0);
    var prev = dummyHead;
    var curr = dummyHead;
    prev.next = head;
    curr.next = head;
    
    while (n > 0) {
        if (curr === null) return null;
        
        curr = curr.next;
        n--;
    }
    
    while (curr.next != null) {
        curr = curr.next;
        prev = prev.next;
    }
    
    prev.next = prev.next.next;
    
    return dummyHead.next;
};