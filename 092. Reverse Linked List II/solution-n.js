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
    counter = n - m;
    runner = runner.next;
    
    while (counter > 0) {
        runner = runner.next;
        counter--;
    }
    
    var lastPartHead = runner.next;
    var reversedHead = reverse(firstPartTail.next, lastPartHead);
    
    firstPartTail.next.next = lastPartHead;
    firstPartTail.next = reversedHead;
    
    return dummyHead.next;
};

var reverse = function(head, tail) {
    var prevNode = null;
    
    while (head !== tail) {
        var nextNode = head.next;
        head.next = prevNode;
        
        prevNode = head;
        head = nextNode;
    }
    
    return prevNode;
}