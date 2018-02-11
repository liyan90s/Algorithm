/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode runner = dummyHead;
        ListNode walker = dummyHead;
        
        int i = 0;
        while (i < m - 1) {
            runner = runner.next;
            walker = walker.next;
            i++;
        }
        ListNode prevReverse = walker;
        
        while (i < n) {
            runner = runner.next;
            i++;
        }        
        ListNode afterReverse = runner.next;
        runner.next = null;
        
        ListNode reversedHead = reverse(walker.next);
        walker.next.next = afterReverse;
        walker.next = reversedHead;
        
        return dummyHead.next;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}