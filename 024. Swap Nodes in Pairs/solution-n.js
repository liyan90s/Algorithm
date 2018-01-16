/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */

// Time: O(n)
var swapPairs = function(head) {
    if (head === null || head.next === null) return head;
    
    var dummyHead = new ListNode(0);
    dummyHead.next = head;
    var walker = dummyHead;
    var runner = head.next;
    
    while (runner != null) {
        var nextNode = runner.next;
        var prevNode = walker;
        walker = walker.next;
        
        prevNode.next = runner;
        runner.next = walker;
        walker.next = nextNode;
        
        if (nextNode !== null) {
            runner = nextNode.next;
        } else {
            return dummyHead.next;
        }
    }
    
    return dummyHead.next;
};