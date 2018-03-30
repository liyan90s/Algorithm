/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode runner = head;
        ListNode walker = head;
        
        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
        }
        
        if (runner != null) {
            walker = walker.next;
        }
        
        ListNode reversedHead = reverse(walker);
        while (reversedHead != null) {
            if (head.val != reversedHead.val) {
                return false;
            }
            
            reversedHead = reversedHead.next;
            head = head.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode reversedHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        
        return reversedHead;      
    }
} 