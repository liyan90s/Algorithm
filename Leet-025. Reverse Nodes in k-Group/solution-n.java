/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        
        int i = 0;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode runner = head;
        ListNode walker = dummyHead;
        
        while (runner != null) {
            ListNode nextNode = runner.next;
            i++;
            
            if (i == k) {
                i = 0;
                
                ListNode reversedHead = reverse(walker.next, nextNode);
                ListNode reversedTail = walker.next;
                
                reversedTail.next = nextNode;
                walker.next = reversedHead;
                
                walker = reversedTail;
            }
            
            runner = nextNode;
        }
        
        return dummyHead.next;
    }
    
    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}