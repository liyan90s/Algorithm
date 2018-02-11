/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode runner = dummyHead;
        ListNode walker = dummyHead;
        
        for (int i = 0; i < n; i++) {
            if (runner == null) {
                return head;
            }
            
            runner = runner.next;
        }
        
        while (runner.next != null) {
            walker = walker.next;
            runner = runner.next;
        }
        
        walker.next = walker.next.next;
        return dummyHead.next;
    }
}