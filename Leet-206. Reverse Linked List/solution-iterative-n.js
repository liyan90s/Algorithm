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
var reverseList = function(head) {
    var prevNode = null;
    
    while (head !== null) {
        var nextNode = head.next;
        head.next = prevNode;
        
        prevNode = head;
        head = nextNode;
    }
    
    return prevNode;
};