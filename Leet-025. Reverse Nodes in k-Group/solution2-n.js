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
    
    var prevPartTail = dummyHead;
    var counter = k;
    
    while (runner !== null) {
        while (counter > 1) {
            runner = runner.next;
            if (runner === null) {
                break;
            }            
            counter--;
        }
        
        if (counter > 1) {
            return dummyHead.next;
        } else {
            counter = k;
            var nextPartHead = runner.next;
            var reversedHead = reverse(prevPartTail.next, nextPartHead);
            var reversedTail = prevPartTail.next;
            
            reversedTail.next = nextPartHead;
            prevPartTail.next = reversedHead;
            
            prevPartTail = reversedTail;
            runner = nextPartHead;
        }
        
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