/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} m
 * @param {number} n
 * @return {ListNode}
 */
var reverseBetween = function(head, m, n) {
    if (m >= n || head === null || head.next === null) {
        return head;
    }
    
    var dummyHead = new ListNode(0);
    dummyHead.next = head;
    var runner = dummyHead;
    var counter = m;
    
    while (counter > 1) {
        runner = runner.next;
        counter--;
    }
    
    var firstPartTail = runner;
    var prevNode = null;
    counter = n - m;
    runner = runner.next;
    
    while (counter >= 0) {
        if (runner === null) {
            return head;
        }
        
        var nextNode = runner.next;
        runner.next = prevNode;
        
        prevNode = runner;
        runner = nextNode;
        counter--;
    }
    
    firstPartTail.next.next = runner;
    firstPartTail.next = prevNode;
    
    return dummyHead.next;
};