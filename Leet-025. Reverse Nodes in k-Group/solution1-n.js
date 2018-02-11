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
var reverseKGroup = function(head, k) {
    if (head === null || head.next === null || k < 2) {
        return head;
    }
    
    var dummyHead = new ListNode(0);
    dummyHead.next = head;
    var runner = head;
    var counter = k;
    var prevTail = dummyHead;
    
    while (runner !== null) {
        counter--;
        var nextNode = runner.next;
        
        if (counter === 0) {
            counter = k;
            var reversedHead = reverse(prevTail.next, nextNode);
            var reversedTail = prevTail.next;
            
            reversedTail.next = nextNode;
            prevTail.next = reversedHead;
            
            prevTail = reversedTail;
        }
        
        runner = nextNode;
    }
    
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
};